package com.lsk.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {
	
	@RequestMapping(value="/test")
	public String test() {
		return "home";
	}
}
