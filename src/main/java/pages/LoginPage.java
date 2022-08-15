package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	

	//****** 1. web elements repository    *******//
	
	@FindBy(name = "username")
	WebElement usernameTxtBox;
    //1 username text box 
	
	@FindBy(css="[placeholder='Password']")
	WebElement passwordTxtBox;
	//2 password text box
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginBtn;
	//3 login button
	
	@FindBy(className="img-responsive")
	WebElement logoImg;
	//4 logo Img
	
    @FindBy (xpath="//*[contains(text(),' GANESH KAKADE ')]")
	WebElement userID;
    //5 userID
	

	//we will use pageFactory to class to initialize web elements
	public LoginPage () {
		PageFactory.initElements(driver, this);
	}
	
	//****** 2. Actions   *****//
	
    public HomePage login(String username, String password) {
	usernameTxtBox.sendKeys(username);
	passwordTxtBox.sendKeys(password);
	loginBtn.click();
	return new HomePage();
}
    
    public String getUserID () {
	  return userID.getText();
	  
   }
     public boolean is_Logo_Displayed() {
	   return logoImg.isDisplayed();
	 }
}
