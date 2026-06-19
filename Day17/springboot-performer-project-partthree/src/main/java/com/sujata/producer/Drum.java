package com.sujata.producer;

import org.springframework.stereotype.Component;

/*
 * if we are not giving any name to the coponent ,
 * then default name will be same as that of class name but in camelCase
 * So in current scenario component name is "drum"
 */
@Component
public class Drum implements Instrument {

	@Override
	public void play() {
		System.out.println("DUM DUM DUM!");

	}

}
