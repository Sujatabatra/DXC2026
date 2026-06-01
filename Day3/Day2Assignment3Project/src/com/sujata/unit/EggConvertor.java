package com.sujata.unit;

public class EggConvertor {

	private int noOfEggs;
	private Unit convertedEggs;

	public EggConvertor() {

	}

	public EggConvertor(int noOfEggs) {
		super();
		setNoOfEggs(noOfEggs);

	}

	public int getNoOfEggs() {
		return noOfEggs;
	}

	public void setNoOfEggs(int noOfEggs) {
		this.noOfEggs = noOfEggs;
		convertedEggs=new Unit();
		convertedEggs.setGross(this.noOfEggs / 144);
		convertedEggs.setDozen(this.noOfEggs % 144 / 12);
		convertedEggs.setRemaining(this.noOfEggs % 144 % 12);
	}

	/*
	 * Unit is an encapsulated entity which is the combination of gross, dozen and
	 * remnaning
	 * without encapsulated entity it was not possible to return three values
	 */
	public Unit getConvertedEggs() {
		return convertedEggs;
	}

}
