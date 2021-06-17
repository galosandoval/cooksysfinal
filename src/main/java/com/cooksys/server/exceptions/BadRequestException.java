package com.cooksys.server.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException{/**
	 * 
	 */
	private static final long serialVersionUID = -1180079707911736369L;

	private String message;
}
