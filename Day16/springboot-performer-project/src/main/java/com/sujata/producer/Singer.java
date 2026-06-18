package com.sujata.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Avneet")
public class Singer implements Performer {

	private String song;

	//Constructor Injection
	public Singer(@Value("Any Song") String song) {
		super();
		this.song = song;
	}

	@Override
	public void perform() {
		System.out.println("Singer is singing " + song);
	}

}
