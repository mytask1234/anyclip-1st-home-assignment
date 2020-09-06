package com.anyclip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyclip.dto.PayloadDto;
import com.anyclip.dto.StatusResponseDto;
import com.anyclip.service.PayloadService;

@RestController
@RequestMapping("/api/v1/payloads")
public class PayloadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayloadController.class);

	@Autowired
	private PayloadService payloadService;
	
	@PostMapping("/")
	public StatusResponseDto process(final @RequestBody PayloadDto payloadDto) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("payloadDto={}", payloadDto);
		}

		payloadService.process(payloadDto);

		return new StatusResponseDto(true);
	}
}
