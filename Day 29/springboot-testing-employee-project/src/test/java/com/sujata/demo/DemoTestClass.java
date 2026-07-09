package com.sujata.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Order of execution
 * @BeforeAll
 * 
 * @Before
 * @Test
 * @After
 * 
 * @Before
 * @Test
 * @After
 * 
 * @AfterAll
 */
class DemoTestClass {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Hi I am setup before class method");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.print("Hi I am tear down after class");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Hi I am setUp method");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Hi i am tear down method");
	}

	//Test Case
	@Test
	void test1() {
//		System.out.println("Test Case 1");
		
		int x=10;
		//test case will pass with value of x is 10
		assertEquals(10, x);
	}

	@Test
	void test2() {
//		System.out.println("Test Case 2");
		String str=null;
		//test case will pass if str is not null
		assertNotNull(str);
		
	}
}
