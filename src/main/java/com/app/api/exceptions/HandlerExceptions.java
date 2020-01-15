package com.app.api.exceptions;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.java.Log;

@RestControllerAdvice
@Log
public class HandlerExceptions {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode generalException(Exception e) {

		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
	}

	@ExceptionHandler(CodeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode codeExcetion(CodeException e) {

		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
	}

	@ExceptionHandler(NameExceptions.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode nameException(NameExceptions e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
	}

	@ExceptionHandler(IdExceptions.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode idException(IdExceptions e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
	}

	@ExceptionHandler(CreditExceptions.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode creditException(CreditExceptions e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
	}

	public String generateId() {
		return UUID.randomUUID().toString();
	}

	public void generateLog(Exception e, ErrorCode ec) {

		log.severe(e.getMessage());
		log.severe(ec.getMessage());
		log.severe(ec.getCode());
	}

}
