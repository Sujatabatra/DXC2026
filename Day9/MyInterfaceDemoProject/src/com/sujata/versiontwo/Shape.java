package com.sujata.versiontwo;

public interface Shape {
	void area();
	void perimeter();
	/*
	 * with defualt method, we need not to modify already created classes,
	 * as all the existing classes will get this default behaviour
	 */
	default void volume() {
		System.out.println(getClass()+" does not support volume method");
	}
}
