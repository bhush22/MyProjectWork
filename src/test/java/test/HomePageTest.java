package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CreateCompanyPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewContactPage;
import util.Utility;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	NewContactPage newContactPage;
	CreateCompanyPage createCompanyPage; 
	
	@Parameters ({"username","password"})
    @BeforeMethod
	public void initialzation(String uname, String pwd) {
		init();
		loginPage = new LoginPage();
		newContactPage=new NewContactPage();
     	homePage = loginPage.login(uname, pwd); //it will return homepage object
	}
	
//	@Test
//	public void validateLogoutTest () {
//	    Utility.switchToMainFrame();
//	    homePage.logout();
//		boolean logoStatus=loginPage.is_Logo_Displayed();
//		Assert.assertTrue(logoStatus);
//	}
	
	@Test
	public void validateRedirectionOfNewContactLink() {
		Utility.switchToMainFrame();
		homePage.clickOnNewContact();
	    Assert.assertEquals(newContactPage.getContactPageTxt(), prop.getProperty("contactPageTxt"));
	}
	@Test
	public void validateRedirectionOfclickOnCompany() {
		Utility.switchToMainFrame();
		homePage.clickOnCompany();
		Assert.assertEquals(createCompanyPage.getCompanyPageTxt(), prop.getProperty("newCompanyPageTxt"));
	}
	@AfterMethod
	public void closeResources () {
		driver.close();
	}
}
