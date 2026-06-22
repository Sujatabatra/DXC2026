package com.sujata.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Bruno")
public class Dancer implements Performer {

	private String style;
	
	//Constructor Injection
	public Dancer(@Value("Rock n Roll") String style) {
		System.out.println("1. Instantiate Dancer, i.e Constructor");
		this.style = style;
	}

	@Override
	public void perform() {
		System.out.println("Dancer is dancing in "+style+" Style");

	}

}
