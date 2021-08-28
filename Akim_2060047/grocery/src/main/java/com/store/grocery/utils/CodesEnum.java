package com.store.grocery.utils;

public enum CodesEnum {
	
	OK("A000","OK"),
	CREATE("A001","Object created"),
	UPDATE("A002","Object updated"),
	PERSISTENCE_ERROR("E000","Persistence error"),
	DATA_NOT_FOUND("E001","Data not found"),
	EMPTY_REQUEST("E002","Empty object request");
	
	private String statusCode;
	private String mesage;
	
	private CodesEnum(String statusCode, String mesage) {
		this.statusCode = statusCode;
		this.mesage = mesage;
	}
	public String getstatusCode() {
		return statusCode;
	}
	public void setstatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
	

}
