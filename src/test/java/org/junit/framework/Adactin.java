package org.junit.framework;

import org.frame.work.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin  {
	
//	WebDriver driver;
//	
//	public Adactin() {
//				
//		PageFactory.initElements(driver, this);
//		//this.driver=driver;
//	}
	@FindBy(id = "username")
	private static WebElement userName;
	@FindBy(id = "password")
	private static WebElement password;
	@FindBy(id="login")
	private static WebElement login;
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}

}
