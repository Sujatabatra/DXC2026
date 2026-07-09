package com.sujata.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;
	
	@BeforeEach
	void setUp() throws Exception {
		calculator=new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		calculator=null;
	}

	@Test
	@DisplayName("Testing addition of 20 and 15")
	void testSum() {
		assertEquals(35, calculator.sum(20, 15));
	}
	
	@Test
	@DisplayName("Testing Differenece between 60 and 40")
	void testDifference() {
		assertEquals(20, calculator.difference(60, 40));
	}
	
	@Test
	void testDivide1() {
		assertEquals(10, calculator.divide(50, 5));
	}
	
	@Test
	void testDivide2() {
		assertThrows(ArithmeticException.class, ()->calculator.divide(20, 0));
	}
	
	@Test
	void testProduct() {
		assertEquals(24, calculator.product(4, 6));
	}
}
