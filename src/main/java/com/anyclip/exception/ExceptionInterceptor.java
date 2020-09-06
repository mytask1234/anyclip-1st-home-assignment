package com.anyclip.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.anyclip.dto.PayloadExceptionResponseDto;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionInterceptor.class);

	@ExceptionHandler(Throwable.class)
	public final ResponseEntity<PayloadExceptionResponseDto> handleAllExceptions(Throwable t) {

		LOGGER.error(t.getMessage(), t);

		PayloadExceptionResponseDto exceptionResponse = new PayloadExceptionResponseDto(t.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
