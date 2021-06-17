package com.cooksys.server.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ImUsedException extends RuntimeException{/**
	 * 
	 */
	private static final long serialVersionUID = -4174096838009498211L;
	
	private String message;
}
