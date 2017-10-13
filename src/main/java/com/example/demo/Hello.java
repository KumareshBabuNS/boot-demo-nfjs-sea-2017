package com.example.demo;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
	
	private CounterService cs;

	public Hello(CounterService cs) {
		this.cs = cs;
	}

	@GetMapping("/hello")
	public String hello() {
		cs.decrement("hello");
		return "greeting";
	}
	
}
