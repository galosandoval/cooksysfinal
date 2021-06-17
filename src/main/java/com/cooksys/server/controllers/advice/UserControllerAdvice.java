package com.cooksys.server.controllers.advice;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cooksys.server.DTOs.ErrorsDTO;
import com.cooksys.server.exceptions.BadRequestException;
import com.cooksys.server.exceptions.ImUsedException;
import com.cooksys.server.exceptions.NotFoundException;

@ControllerAdvice(basePackages = {"com.cooksys.server.controllers"})
@ResponseBody
public class UserControllerAdvice {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ErrorsDTO handleNotFoundException(HttpServletRequest request, NotFoundException notFoundException) {
		return new ErrorsDTO(notFoundException.getMessage());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ErrorsDTO handleBadRequestException(HttpServletRequest request, BadRequestException badRequestException) {
		return new ErrorsDTO(badRequestException.getMessage());
	}
	
	@ResponseStatus(HttpStatus.IM_USED)
	@ExceptionHandler(ImUsedException.class)
	public ErrorsDTO handleImUsedException(HttpServletRequest request, ImUsedException imUsedException) {
		return new ErrorsDTO(imUsedException.getMessage());
	}
}
