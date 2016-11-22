package com.lsk.android.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/android")
public class TestApiController {
	
	@RequestMapping("/test")
	public String testApi(){
		return "connected!";
	}
}
