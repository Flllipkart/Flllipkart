package org.junit.framework;

import org.frame.work.BaseClass;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample extends BaseClass {
	
	public static void main(String[] args) {
		
		broweserConFig();
		openUrl("https://adactinhotelapp.com/HotelAppBuild2/");
		maximizeWindow();
		Adactin obj= new Adactin();
		PageFactory.initElements(driver, Adactin.class);
		textInput(obj.getUserName(), "kannan123");
		refresh();
		textInput(obj.getUserName(), "kannan");
	}

}
