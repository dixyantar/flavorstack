package com.flavorstack.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping(value = "")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping(value = "/article")
	public String article() {
		return "admin/article";
	}

}
