package com.sujata.training;

/*
 * import all the static members from the specified class,
 * by doing so everytime whenever we will be calling static members
 *  we need not to use class name
 *  
 *  Also Note : if we want to create the object of the import static class,
 *  then import static will not work but we need to import that class
 */
import static com.sujata.demo.StaticImportDemoClass.*;

import com.sujata.demo.StaticImportDemoClass;

//Different class and different package
public class StaticImportDemoMainClass {

	public static void main(String[] args) {
		
//		com.sujata.demo.StaticImportDemoClass.first();
		
//		StaticImportDemoClass.fifth();
		first();
		fifth();
		third();
		second();
	
		StaticImportDemoClass staticImportDemoClass=new StaticImportDemoClass();
		staticImportDemoClass.fourth();
		staticImportDemoClass.sixth();
		
		System.out.println(PI);
		System.out.println(staticImportDemoClass.PI);
		
		System.out.println(staticImportDemoClass.name);
		
	}
	

}
