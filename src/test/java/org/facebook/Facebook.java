package org.facebook;

import org.frame.work.BaseClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Facebook extends BaseClass {
	
	@Test
public void test() throws InterruptedException {
		
		
		//Facebook obj= new Facebook();
		//obj.broweserConFig();
		openUrl("https://www.facebook.com/");
		maximizeWindow();
	}
		
//		WebElement locateById = obj.locateById("email");
//		obj.textInput(locateById,"kannan");
//		WebElement locateById2 = obj.locateById("pass");
//		obj.textInput(locateById2, "pass@123");
//		WebElement locateByName = obj.locateByName("login");
//		obj.click(locateByName);
//		WebElement locateByXpath = obj.locateByXpath("//div[contains(text(),'The password ')]");
//		String gettext = obj.gettext(locateByXpath);
//		Thread.sleep(9000);
//		Assert.assertEquals("The password that you've entered is incorrect. Forgotten password?", gettext);
//		WebElement locateByXpath2 = obj.locateByXpath("(//a[contains(text(),'Forgotten password?')])[2]");
//		obj.click(locateByXpath2);
//	}
	@Test
	public void test2() {
		openUrl("https://www.google.co.in/");
		maximizeWindow();
	}

	
	

}
