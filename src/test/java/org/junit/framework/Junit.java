package org.junit.framework;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Browser configur and browser launch");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("Close and quit browser");
	}
	@Before
	public void beforeEachMethod() {
		System.out.println("start time");
	}
	@After
	public void afterEachMethod() {
		System.out.println("end time");

	}@Test
	public void tc1() {
	System.out.println("Tc1");
	}
	@Test
	public void tc2() {
		System.out.println("Tc2");
		
	}
	@Test
	public void tc3() {
		System.out.println("Tc3");
		}
	@Test
		public void tc4() {
			System.out.println("Tc4");
			
		}
	@Test
		public void tc5() {
			System.out.println("Tc5");
			}
	@Test
			public void tc6() {
				System.out.println("Tc6");
				
			}
}

