package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LegacyHealthIndicator
	implements HealthIndicator {

	@Override
	public Health health() {
		
		double random = Math.random();
		if (random > 0.5) {
			return
					Health.up()
						.withDetail("status", "The random number was big enough")
						.build();
		}
		
		return Health.down()
					.withDetail("reason", "Value too low")
					.withDetail("time", System.currentTimeMillis())
					.build();
	}
	
}
