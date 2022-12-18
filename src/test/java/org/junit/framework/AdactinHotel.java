package org.junit.framework;

import java.io.IOException;

import org.frame.work.BaseClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;


public class AdactinHotel extends BaseClass {
	@Before
	public void beforeMethod() {
		broweserConFig();
		openUrl("https://adactinhotelapp.com/HotelAppBuild2/");
		maximizeWindow();
	}
	@Test
	public void test() throws InterruptedException, IOException {
		WebElement userName = locateById("username");
		textInput(userName, excelRead("C:\\Users\\HP\\eclipse-workspace1\\Framework\\files\\Framework Excel.xlsx", "Sheet1", 1, 6));
		WebElement passWord = locateById("password");
		textInput(passWord, excelRead("C:\\Users\\HP\\eclipse-workspace1\\Framework\\files\\Framework Excel.xlsx", "Sheet1", 2, 6));
		locateById("login").click();
		WebElement location = locateById("location");
		//locateById.sendKeys("london");
		selectByVisibleText(location,"London");
		WebElement hotel = locateById("hotels");
		selectByValue(hotel, "Hotel Hervey");
		selectByIndex(hotel, 1);
		WebElement roomType = locateById("room_type");
		selectByVisibleText(roomType, "Standard");
		WebElement roomNos = locateById("room_nos");
		selectByIndex(roomNos, 5);
		WebElement dateIn = locateById("datepick_in");
		dateIn.clear();
		textInput(dateIn, excelRead("C:\\Users\\HP\\eclipse-workspace1\\Framework\\files\\Framework Excel.xlsx", "Sheet1", 1, 5));
		WebElement dateOut = locateById("datepick_out");
		dateOut.clear();
		textInput(dateOut, excelRead("C:\\Users\\HP\\eclipse-workspace1\\Framework\\files\\Framework Excel.xlsx", "Sheet1", 2, 5));
		WebElement adultPerRoom = locateById("adult_room");
		selectByValue(adultPerRoom, "2");
		WebElement childRoom = locateById("child_room");
		selectByIndex(childRoom, 3);
		locateById("Submit").click();
		locateById("radiobutton_0").click();
		locateById("continue").click();
		WebElement firstName = locateById("first_name");
		textInput(firstName, excelRead("C:\\\\Users\\\\HP\\\\eclipse-workspace1\\\\Framework\\\\files\\\\Framework Excel.xlsx", "Sheet1", 8, 1));
		WebElement lastName = locateById("last_name");
		lastName.sendKeys("kumar");
		locateById("address").sendKeys("no 5 chennai");
		locateById("cc_num").sendKeys("1234567890123456");
		WebElement ccType = locateById("cc_type");
		selectByVisibleText(ccType, "American Express");
		WebElement expMonth = locateById("cc_exp_month");
		selectByVisibleText(expMonth, "January");
		WebElement expYear = locateById("cc_exp_year");
		selectByVisibleText(expYear, "2020");
		locateById("cc_cvv").sendKeys("708");
		locateById("book_now").click();
		
		Thread.sleep(3000);
		//close();

	}

}
