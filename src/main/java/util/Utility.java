package util;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import base.TestBase;

    public class Utility extends TestBase {
	
  public static void switchToMainFrame() {
		driver.switchTo().frame("mainpanel");
}
   public static void mouseOver(WebElement target) {
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
}
   public static void selectDropDown(WebElement element, String dropDownName) {
		Select sel =new Select(element);
		sel.selectByVisibleText(dropDownName);
}
   public static String[][] getData() throws IOException {
	   
		FileInputStream file= new FileInputStream("D:\\Soft_Test\\Book1.xlsx\\");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("fy");
		int rows = sheet.getLastRowNum();
   //	System.out.println("rows");
		int columns= sheet.getRow(0).getLastCellNum();
   //	System.out.println(columns);

		String data[][]= new String [rows][columns];
        for(int i=0;i<=rows;i++) //rows
	       {
        	for(int j=0;j<columns;j++) //columns
		        { 
		         data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
		  return data;  //change void to String[][]
}
}
