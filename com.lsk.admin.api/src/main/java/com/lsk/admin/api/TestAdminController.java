package com.lsk.admin.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class TestAdminController {

	@RequestMapping(value = "/test")
	public String test() {
		return "home";
	}
}
