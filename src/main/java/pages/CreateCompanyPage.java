package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CreateCompanyPage extends TestBase {

	// 1. WebElement repository
	
	@FindBy(xpath="//*[text()='Create New  Company']")
	WebElement companyPageTxt;
	
	// 2. Actions
	
	public String getCompanyPageTxt() {
		return companyPageTxt.getText();
	}
	
	// 3. Initialization using PageFactory class
	
	public void createCompanyPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
