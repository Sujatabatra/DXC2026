package com.sujata.training;



import com.sujata.demo.Audi;
import com.sujata.demo.BMW;
import com.sujata.demo.Car;
import com.sujata.demo.ConcreteBMW;
import com.sujata.demo.Driver;
import com.sujata.demo.Kia;
import com.sujata.demo.Toyota;

public class CarRentalSystem {

	public static void main(String[] args) {
		ConcreteBMW bmw=new ConcreteBMW("Q5", "Black");
		Audi audi=new Audi("A8", "Silver");
		Toyota toyota=new Toyota("Altis", "Golden");
		Kia kia=new Kia("Seltos", "Grey");
		
		Driver sonu=new Driver("Sonu");
		Driver will=new Driver("Will");
		
		
		sonu.setCar(audi);
		sonu.drive();
		
		will.setCar(bmw);
		will.drive();
		
//		Car car=new Car("X","Red"); 
		

	}

}
