package com.anyclip.dto;

public class PayloadExceptionResponseDto {

	private String errorMessage;

	public PayloadExceptionResponseDto(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
