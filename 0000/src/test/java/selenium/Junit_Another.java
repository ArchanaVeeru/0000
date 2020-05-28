package selenium;

import java.util.Arrays;
import java.util.Collection;

//import static org.junit.Assert.*;


import org.junit.After;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class Junit_Another {

private int a,b;
//private int c;
public Junit_Another(int a,int b) {
	this.a=a;
	this.b=b;
	
}
@Parameterized.Parameters
public static Collection<Object[]> getData() {
	
	return Arrays.asList((new Object[][] {{2,4},{6,8},{9,10}}));
	
}

	@Test
	public void add() {
		int c;
		System.out.println(c=a+b);
		
	}
//	@Ignore
//	@Test
//	public void fail1() {
//		
//		System.out.println("test1");
//	}

}
