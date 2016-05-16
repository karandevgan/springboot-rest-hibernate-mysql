package com.psl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psl.demo.dao.GreetingDao;
import com.psl.demo.model.Greeting;

@RestController
public class GreetingController {
	@Autowired
	private GreetingDao greetingDao;
	
	@RequestMapping(method = RequestMethod.GET, path = "/setgreeting")
	public String setGreeting() {
		Greeting greeting = new Greeting();
		greeting.setContent("Set by Karan");
		greetingDao.save(greeting);
		return "Greeting Saved";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getgreeting")
	public Object getGreeting(@RequestParam(name="id")long id) {
		Greeting greeting =  greetingDao.findById(id);
		if (greeting == null) {
			return "No Greeting With Id: " + id;
		}
		else {
			return greeting;
		}
	}
}
