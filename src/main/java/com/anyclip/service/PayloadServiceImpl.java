package com.anyclip.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anyclip.dto.PayloadDto;
import com.anyclip.dto.VariantDto;
import com.anyclip.exception.PayloadException;

@Service
public class PayloadServiceImpl implements PayloadService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayloadServiceImpl.class);

	private static final String LOGS_DIR = "logs/";

	private final AtomicInteger counter = new AtomicInteger();

	private final List<AtomicInteger> variantCounters = new ArrayList<>();

	public PayloadServiceImpl() {

		File directory = new File(LOGS_DIR);

		if (directory.exists() == false){
			
			directory.mkdir();
		}
	}

	@Override
	public void process(final PayloadDto payloadDto) {

		if (counter.get() > payloadDto.getLogLimit()) {
			return;
		}

		boolean abTestEnabled = payloadDto.getAbTest().getEnabled();

		if (abTestEnabled == false) {

			writeToFile(payloadDto.getLogFile(), "NA", counter);

		} else { // abTestEnabled == true

			List<VariantDto> variants = payloadDto.getAbTest().getVariants();

			initVariantCounters(variants.size());

			int i = 0;
			for (VariantDto variantDto : variants) {

				int percentage = variantDto.getPercentage();

				int maxLinesInFile = (int)(percentage * payloadDto.getLogLimit() / (double)100);

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("percentage={}, maxLinesInFile={}, variantCounters={}, variantDto={}", percentage, maxLinesInFile, variantCounters, variantDto);
				}

				if (variantCounters.get(i).get() < maxLinesInFile) {

					String fileName = variantDto.getLogFile() != null ? variantDto.getLogFile() : payloadDto.getLogFile();

					writeToFile(fileName, variantDto.getVariantName(), variantCounters.get(i));

					return;
				}

				++i;
			}
		}
	}

	private void initVariantCounters(final int numOfVariants) {

		if (variantCounters.isEmpty() && numOfVariants > 0) {

			synchronized (variantCounters) {

				if (variantCounters.isEmpty()) {

					for (int i = 0 ; i < numOfVariants ; i++) {

						variantCounters.add(new AtomicInteger());
					}
				}
			}
		}
	}

	private void writeToFile(String fileName, String line, AtomicInteger counter) {

		File file = new File(LOGS_DIR + fileName);

		// try-with-resources
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

			bw.write(String.format("%s%s", line, System.lineSeparator()));

			counter.incrementAndGet();

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("fileName={}, line={}, counter={}", fileName, line, counter);
			}

		} catch (Throwable t) {

			String message = String.format("failed to write line '%s' to file '%s'. counter: %d", line, fileName, counter.get());

			throw new PayloadException(message, t);
		}
	}
}
