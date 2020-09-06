package com.anyclip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayloadDto {

	private String logFile;
	private Integer logLimit;
	@JsonProperty("ab_test")
	private AbTestDto abTest;
	
	public String getLogFile() {
		return logFile;
	}
	
	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}
	
	public Integer getLogLimit() {
		return logLimit;
	}
	
	public void setLogLimit(Integer logLimit) {
		this.logLimit = logLimit;
	}
	
	public AbTestDto getAbTest() {
		return abTest;
	}
	
	public void setAbTest(AbTestDto abTest) {
		this.abTest = abTest;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayloadDto [logFile=");
		builder.append(logFile);
		builder.append(", logLimit=");
		builder.append(logLimit);
		builder.append(", abTest=");
		builder.append(abTest);
		builder.append("]");
		return builder.toString();
	}
}
