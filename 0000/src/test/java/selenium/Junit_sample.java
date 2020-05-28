package selenium;

//import static org.junit.Assert.*;


import org.junit.After;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Junit_sample {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void fail() {
		int a=10,b=5,c;
		System.out.println(c=a+b);
		
		System.out.println("test");
	}
	@Ignore
	@Test
	public void fail1() {
		
		System.out.println("test1");
	}

}
