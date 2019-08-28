package com.java.clientservice1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	LoadBalancerClient client;

	@GetMapping(value="/service1/limiting/{value}")
	public ArrayList<User> getData(@PathVariable String value) {
		ArrayList<User> userList = new ArrayList<>();
		ServiceInstance clientName = client.choose("Config-Client-2");
		String url = "/service2/search/user";
		String finalUri = clientName.getUri()+url;
		HttpEntity<String> entity = new HttpEntity<>(value);
		ResponseEntity<ArrayList> response = null;
		try {
			response = resttemplate.exchange(finalUri, HttpMethod.POST, entity, ArrayList.class);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(null!=response) {
			userList = response.getBody();
		}
		return userList;
	}
}
