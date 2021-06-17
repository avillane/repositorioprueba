package com.everis.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.everis.model.Greeting;

@Service
public class GreetingServiceImpl implements IGreetingService{
	
	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello %s";
	
	@Override
	public Greeting Greetings(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
