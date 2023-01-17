package com.library.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.model.Demo;
import com.library.demo.service.Payment;

@RestController
public class DemoController {
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	Payment payment;
	
	Demo demo = new Demo();

	
	@GetMapping("/demo")
	public Demo getDemo() {
		logger.info("Demo obj is {}", demo);
		return demo;
	}
	
	@PostMapping("/demo/id")
	public Demo saveDemo(@RequestParam int id) {
		logger.info("Demo id is {}",id);
		return demo;
	}
	
	@ResponseBody
	@RequestMapping("/reqbody")
	public Demo reqBodyGetName(@RequestBody Demo demoobj) {
		logger.info("Name is {}",demoobj.getName());
		return demoobj;
	}

}
