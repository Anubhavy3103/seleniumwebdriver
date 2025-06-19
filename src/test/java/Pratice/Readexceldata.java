package Pratice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexceldata {

	public static void main(String[] args) throws IOException {
		
	  FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"/testdata/Practice Data.xlsx");
	  
	  XSSFWorkbook workbook = new XSSFWorkbook(file);
	  
	  XSSFSheet sheet =workbook.getSheet("Data Practice");
	
	  int totalrow = sheet.getLastRowNum();
	  
	  int totalcells = sheet.getRow(1).getLastCellNum();
	
	  System.out.println("Number of row: " + totalrow);
	  
	  System.out.println("Number of row: " + totalcells);
	  
	  
	}

}
