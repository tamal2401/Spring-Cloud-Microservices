package com.java.clientservice1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java.clientservice1.model.User;

@RestController
public class Controller {

	@Value("${data.limit:3}")
	public String limit;

	@Autowired
	@Qualifier(value="LoadbalancedRestTemplate")
	private RestTemplate resttemplate;

	@RequestMapping(value="/service1/limiting/{value}", method=RequestMethod.POST)
	public ArrayList<User> getData(@PathVariable String value) {
		ArrayList<User> userList = new ArrayList<>();
		String url = "/service2/search/user";
		HttpEntity<String> entity = new HttpEntity<>(value);
		ResponseEntity<ArrayList> response = resttemplate.exchange(url, HttpMethod.POST, entity, ArrayList.class);
		if(null!=response) {
			userList = response.getBody();
		}
		;
		return userList;
	}
}
