package com.sujata.versiontwo;

public class CalculateShape2DAnd3D extends CalculateShape2D {

	@Override
	public void calculate() {
		super.calculate();
		getShape().volume();
	}
}
