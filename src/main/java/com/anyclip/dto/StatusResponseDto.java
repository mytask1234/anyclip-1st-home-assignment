package com.anyclip.dto;

public class StatusResponseDto {

	private final boolean success;

	public StatusResponseDto(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusResponseDto [success=");
		builder.append(success);
		builder.append("]");
		return builder.toString();
	}
}
