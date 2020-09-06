package com.anyclip.dto;

public class VariantDto {

	private String variantName;
    private Integer percentage;
    private String logFile;
    
	public String getVariantName() {
		return variantName;
	}
	
	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}
	
	public Integer getPercentage() {
		return percentage;
	}
	
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	
	public String getLogFile() {
		return logFile;
	}
	
	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VariantDto [variantName=");
		builder.append(variantName);
		builder.append(", percentage=");
		builder.append(percentage);
		builder.append(", logFile=");
		builder.append(logFile);
		builder.append("]");
		return builder.toString();
	}

    
}
