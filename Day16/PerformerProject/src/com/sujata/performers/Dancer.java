package com.sujata.performers;


public class Dancer implements Performer {

	private String style;
	
	public Dancer(String style) {
		this.style = style;
	}

	@Override
	public void perform() {
		System.out.println("Dancer is dancing in "+style+" Style");

	}

}
