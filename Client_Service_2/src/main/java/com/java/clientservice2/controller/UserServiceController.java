package com.java.clientservice2.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.clientservice2.model.User;

@RestController
public class UserServiceController {

	@RequestMapping(value="/service2/search/user", method=RequestMethod.POST, produces="application/json")
	public List<User> getData(String value) {

		List<User> userList = populateUser();
		int ageParam = Integer.valueOf(value);
		int maxAge = ageParam+10;
		int minAge = ageParam-10;	

		List<User> list = userList.stream()
								  .filter(e -> (e.getAge()>minAge)||(e.getAge()<maxAge))
								  .collect(Collectors.toList());
		return list;
	}

	private List<User> populateUser() {
		User u1 = new User("tamal","tamal.das@gmail.com",25);
		User u2 = new User("shila","shila.das@gmail.com",50);
		User u3 = new User("tarak","tarak.das@gmail.com",62);
		User u4 = new User("susmita","susmita.das@gmail.com",22);
		User u5 = new User("epshita","epshita.das@gmail.com",20);
		User[] arr = new User[]{u1,u2,u3,u4,u5};
		List<User> userList = Arrays.asList(arr);
		return userList;
	}
}
