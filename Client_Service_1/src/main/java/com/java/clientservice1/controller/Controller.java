package com.java.clientservice1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Value("${data.limit:3}")
	public String limit;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String getData() {
		return limit;
	}
}
