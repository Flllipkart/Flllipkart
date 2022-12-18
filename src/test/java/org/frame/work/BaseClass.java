package org.frame.work;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static void  broweserConFig() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
    }
	public static void openUrl(String Url) {
		driver.get(Url);
		
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public WebElement locateById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	public WebElement locateByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	public WebElement locateByClass(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;
	}
	public WebElement locateByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	public WebElement locateByLinkText(String linkText) {
		WebElement element = driver.findElement(By.linkText(linkText));
		return element;
	}
	public WebElement locateByTagName(String name) {
		WebElement element = driver.findElement(By.tagName(name));
		return element;
	}
	public String title() {
		String title = driver.getTitle();
		return title;
	}
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public String windowHandles(int index) {
		Set<String> allWindowId = driver.getWindowHandles();
		List<String> li= new ArrayList();
		li.addAll(allWindowId);
		String childwindow = li.get(index);//index 0 means parent window,index 1 means child window
		return childwindow;
	}
	public void switchWindow(String windowId) {
		driver.switchTo().window(windowId);

	}
	public void click(WebElement element) {
		
		element.click();

	}
	public void switchFrame(int index) {
		driver.switchTo().frame(index);

	}
	public void switchToFrame(String name) {
		driver.switchTo().frame(name);

	}
	private void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);

	}
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();	
	}
	public void alertSendKeys(String keys) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keys);
	}
	public static void textInput(WebElement element, String value) {
		element.sendKeys(value);

	}
	public void close() {
		driver.close();
	}
	public void quit() {
		driver.quit();
	}
	public void selectByValue(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByValue(value); 

	}
	public void selectByIndex(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index); 

	}
	public void selectByVisibleText(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByVisibleText(value); 
	}
	public void openUrlNavigate(String url) {
		driver.navigate().to(url);
	}
	public void back() {
		driver.navigate().back();
	}
	public void forward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();

	}
	public void moveToelement(WebElement element) {
		Actions a= new Actions(driver);
		Actions moveToElement = a.moveToElement(element);
		moveToElement.perform();

	}
	public void dragandDrop(WebElement elementSource, WebElement elementDestination) {
		Actions a= new Actions(driver);
		Actions dragAndDrop = a.dragAndDrop(elementSource, elementDestination);
		dragAndDrop.perform();
	}
	private void doubleClick(WebElement element) {
		Actions a= new Actions(driver);
		a.doubleClick(element).perform();
	}
	private void inputTextInActiveElement(String value) {
		WebElement activeElement = driver.switchTo().activeElement();
		activeElement.sendKeys(value);
	}
	public void inputTextJs(String name, WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].value='name'", element);

	}
	public void inputTextJsSetAttribute(String name, WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].SetAttribute('value','name')", element);
	}
	public void clickJs(WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);

	}
	public void scrollDown(WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollintoView(true)", element);
	}
	public void scrollUp(WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollintoView(false)", element);
	}
	public Sheet excel(String name) throws IOException {
		File f= new File("C:\\Users\\HP\\eclipse-workspace1\\Framework\\files\\Framework Excel.xlsx");
		FileInputStream fin= new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet(name);
		return sheet;
	}
	public Row row(String SheetName,int rowNumber) throws Exception {
		Sheet s=excel(SheetName);
		Row r=s.getRow(rowNumber);
		return r;
	}
	public Cell cell(String sheetName, int rownumber,int cellnumber) throws Exception {
		Row row=row(sheetName, rownumber);
		Cell cell = row.getCell(cellnumber);
		return cell;
		
	}
	public String gettext(WebElement element) {
		String text = element.getText();
		return text;

	}
	public String excelRead(String path, String sheetName, int rowNumber,int cellnumber) throws IOException {
		String value=null;;
		File f= new File(path);
		FileInputStream fin= new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet(sheetName);
		Row r=sheet.getRow(rowNumber);
		Cell cell = r.getCell(cellnumber);
		int cellType = cell.getCellType();
		if(cellType==1) {
			value = cell.getStringCellValue();
			
		}
		else if(cellType==0) {
			if(DateUtil.isCellDateFormatted(cell))
			{
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim= new SimpleDateFormat("dd/MM/yyyy");
				value = sim.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l= (long)numericCellValue;
				value=String.valueOf(l);
			}
		}
		return value;
	}
		
		
		

	}