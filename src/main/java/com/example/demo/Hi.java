package com.example.demo;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hi {

	private NamesRepository repo;
	private GreetingProps props;
	private CounterService cs;
	private GaugeService gs;

	public Hi(NamesRepository repo,
				GreetingProps props,
				CounterService cs,
				GaugeService gs) {
		this.repo = repo;
		this.props = props;
		this.cs = cs;
		this.gs = gs;
	}

	@GetMapping("/")
	public String hi() {
		gs.submit("hello", Math.random());
		cs.increment("hello");
		return props.getMessage() + ", " + repo.getFirstName() + "!";
	}
	
}
