package test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewContactPage;
import util.Utility;

public class NewContactPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	NewContactPage newContactPage;
	
	
	@BeforeMethod
	public void initialzation (){
		init();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@DataProvider(name="empData")
	public String[][] passData() throws IOException {
		String data[][] = Utility.getData();
		return data;
	}
	
	@Test(dataProvider="empData")
	public void validateNewContactPageTest (String FN, String LN, String compName, String mob, String add) {
		Utility.switchToMainFrame();
		newContactPage=homePage.clickOnNewContact();
		newContactPage.createNewContactPage(FN, LN, compName, mob, add);
		
	}
	
//	@AfterMethod
//	public void closeResources () {
//		driver.close();
//	}
	}
