package com.app.finanace.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class EnquiryDto {

	private String message;
	private LocalDateTime locaDateTime;

	private String url;

	private HttpStatus status;

	public EnquiryDto() {
		super();

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getLocaDateTime() {
		return locaDateTime;
	}

	public void setLocaDateTime(LocalDateTime locaDateTime) {
		this.locaDateTime = locaDateTime;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public EnquiryDto(String message, LocalDateTime locaDateTime, String httpRequest, HttpStatus status) {
		super();
		this.message = message;
		this.locaDateTime = locaDateTime;
		this.url = httpRequest;
		this.status = status;
	}

	public String getHttpRequest() {
		return url;
	}

	public void setHttpRequest(String httpRequest) {
		this.url = httpRequest;
	}

}
