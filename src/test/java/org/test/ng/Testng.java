package org.test.ng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng {
	WebDriver driver;
	@BeforeClass
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	@AfterClass
	private void afterClass() {
	driver.close();

	}
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("hi");
	}
//		
//	}
	@AfterMethod
	private void afterMethod() {
		System.out.println("passed");

	}
	@Test
	private void faceBook() {
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		
		
		

	}
	}
	

