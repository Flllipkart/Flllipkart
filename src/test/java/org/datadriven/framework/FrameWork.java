package org.datadriven.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FrameWork {
	public static void main(String[] args) throws IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver= new ChromeDriver();
		File f= new File("C:\\Users\\HP\\eclipse-workspace1\\Framework\\files\\Framework Excel.xlsx");
		FileInputStream filin= new FileInputStream(f);
		Workbook w= new XSSFWorkbook(filin);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(2);
		Cell cell = r.getCell(4);
		//System.out.println(cell);
		int physicalNumberOfRows = s.getPhysicalNumberOfRows();
		int physicalNumberOfCells = r.getPhysicalNumberOfCells();
		int lastRowNum = s.getLastRowNum();
		int firstRowNum = s.getFirstRowNum();
		  int lastCellNum = r.getLastCellNum();
		  int firstCellNum = r.getFirstCellNum();
		  System.out.println(lastRowNum);
		  System.out.println(lastCellNum);
		  System.out.println(physicalNumberOfRows);
		  System.out.println(physicalNumberOfCells);
		  System.out.println(firstRowNum);
		  System.out.println(firstCellNum);
		for(int i=0;i<physicalNumberOfRows;i++) {
			Row row1 = s.getRow(i);
			
			//System.out.println(row1);
			for(int j=0;j<physicalNumberOfCells;j++) {
				Cell cell2 = row1.getCell(j);
				int cellType = cell2.getCellType();
				if(cellType==1) {
					String stringCellValue = cell2.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else if(cellType==0){
					if(DateUtil.isCellDateFormatted(cell2)) {
						Date dateCellValue = cell2.getDateCellValue();
						SimpleDateFormat sim= new SimpleDateFormat("dd-MM-yyyy");
						String format = sim.format(dateCellValue);
						System.out.println(format);
					}
					else {
						double numericCellValue = cell2.getNumericCellValue();
						long l= (long)numericCellValue;
						String valueOf = String.valueOf(l);
						System.out.println(valueOf);
						
					}
					
				}
				//System.out.println(cell2);
			}
		}
				
		
		
	}

}
