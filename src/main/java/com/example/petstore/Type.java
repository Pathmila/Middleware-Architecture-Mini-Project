package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "Type")
public class Type {
	
	@Schema(required = true, description = "Type id")
	@JsonProperty("type_id")
	private Integer typeId;

	@Schema(required = true, description = "Type name")
	@JsonProperty("type_name")
	private String petType;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

}
