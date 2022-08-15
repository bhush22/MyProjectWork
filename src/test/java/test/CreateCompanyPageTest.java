package test;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CreateCompanyPage;
import pages.HomePage;
import pages.LoginPage;
import util.Utility;

public class CreateCompanyPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CreateCompanyPage createCompanyPage;
	
  
	@Parameters ({"username","password"})
	@BeforeMethod
	public void initialization(String uname, String pwd) {
		init();
		loginPage= new LoginPage();
		homePage= loginPage.login(uname, pwd);
	}
	
	@Test
	public void validateCreateNewCompanyPage() {
		Utility.switchToMainFrame();
		homePage.
		String txt=createCompanyPage.getCompanyPageTxt();
		System.out.println(txt);
		//Assert.assertEquals(txt, prop.getProperty("newCompanyPageTxt"));
	}
	
	@AfterMethod
	public void closeResources () {
		driver.close();
	}
	
	
}
