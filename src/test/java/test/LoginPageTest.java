package test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.TestBase;
import pages.LoginPage;
import util.Utility;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;

	@BeforeMethod
	public void initialzation (){
		init();
		loginPage = new LoginPage();
	}
	
	@Parameters({"username","password"})
	@Test
	public void validateLoginTest (String uid, String pwd) {
		loginPage.login(uid, pwd);
		Utility.switchToMainFrame();
		String userName=loginPage.getUserID();
		System.out.println(userName);
		Assert.assertEquals(userName, "  User: GANESH KAKADE");
	
	}
		
		@Test
		public void validateLogoTest() {
		boolean logoStatus=	loginPage.is_Logo_Displayed();
		Assert.assertEquals(logoStatus, true);
		}
	
	@AfterMethod
	public void closeResources () {
		driver.close();
	}
}
