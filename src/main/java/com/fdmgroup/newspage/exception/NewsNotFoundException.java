package com.fdmgroup.newspage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NewsNotFoundException extends RuntimeException {
	public NewsNotFoundException(int newsid) {
		super("The news with id: " + newsid + " could not be found.");
	}
}
