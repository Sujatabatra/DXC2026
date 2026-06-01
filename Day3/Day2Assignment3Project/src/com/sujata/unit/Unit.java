package com.sujata.unit;

//POJO :Plain Old Java Object
public class Unit {

	private int gross,dozen,remaining;
	
	public Unit() {
		
	}

	public Unit(int gross, int dozen, int remaining) {
		super();
		this.gross = gross;
		this.dozen = dozen;
		this.remaining = remaining;
	}

	public int getGross() {
		return gross;
	}

	public void setGross(int gross) {
		this.gross = gross;
	}

	public int getDozen() {
		return dozen;
	}

	public void setDozen(int dozen) {
		this.dozen = dozen;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	@Override
	public String toString() {
		return "Unit [gross=" + gross + ", dozen=" + dozen + ", remaining=" + remaining + "]";
	}
	
	
	
}
