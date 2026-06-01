package com.sujata.unit;

public class EggConvertorMain {

	public static void main(String[] args) {
		
		EggConvertor eggConvertor=new EggConvertor();
		
		eggConvertor.setNoOfEggs(1040);
		
		Unit eggUnit=eggConvertor.getConvertedEggs();
		
		System.out.println(eggUnit);

	}

}
