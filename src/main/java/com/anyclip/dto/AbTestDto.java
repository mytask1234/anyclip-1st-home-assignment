package com.anyclip.dto;

import java.util.List;

public class AbTestDto {

	private Boolean enabled;
	private List<VariantDto> variants;
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<VariantDto> getVariants() {
		return variants;
	}
	
	public void setVariants(List<VariantDto> variants) {
		this.variants = variants;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbTestDto [enabled=");
		builder.append(enabled);
		builder.append(", variants=");
		builder.append(variants);
		builder.append("]");
		return builder.toString();
	}
}
