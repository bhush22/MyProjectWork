package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file= new FileInputStream("D:\\Soft_Test\\Book1.xlsx\\");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	
		XSSFSheet sheet= workbook.getSheet("fy");
		
		int rows = sheet.getLastRowNum();
		System.out.println("rows");
		
		int columns= sheet.getRow(0).getLastCellNum();
		System.out.println(columns);
		
	
	for(int i=0;i<=rows;i++) //rows
	{
		for(int j=0;j<columns;j++) //columns
		{ //System.out.println(sheet.getRow(i).getCell(j).toString());
		String eachValue=sheet.getRow(i).getCell(j).toString();	
		System.out.print(eachValue+"      ");
		}
		System.out.println();
	}
	}
		  
}
