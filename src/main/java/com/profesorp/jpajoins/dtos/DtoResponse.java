package com.profesorp.jpajoins.dtos;

import org.springframework.http.HttpStatus;

import com.profesorp.jpajoins.entities.Invoiceheader;

import lombok.Data;

@Data
public class DtoResponse {
	long interval;
	HttpStatus httpStatus;
	Invoiceheader invoiceHeader; 
}
