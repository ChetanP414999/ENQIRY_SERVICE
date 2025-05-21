package com.app.finanace.globalexception;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.finanace.dto.EnquiryDto;
import com.app.finanace.exceptions.EnquiryObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class ExceptionHandlers {
	

	@ExceptionHandler(EnquiryObjectNotFoundException.class)
	public ResponseEntity<EnquiryDto> onExceptionHandler(EnquiryObjectNotFoundException e,HttpServletRequest request){

		EnquiryDto dto=new EnquiryDto(e.getMessage(),LocalDateTime.now(),request.getRequestURI(),HttpStatus.NOT_FOUND);

		return new ResponseEntity<EnquiryDto>(dto,HttpStatus.NOT_FOUND);
	}

}
