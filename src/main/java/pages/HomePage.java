package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import util.Utility;

public class HomePage extends TestBase {
	
	//1 web elements repository
	
	@FindBy(xpath="//*[contains(text(),' Logout ')]")
	WebElement logoutBtn;
	// Logout
	
	@FindBy(xpath="//*[text()='Contacts']")
	WebElement contacts;
	// Contacts
	
	@FindBy(xpath="//*[contains(text()='New Contact']")
	WebElement createNewContactLink;
	// New Contact
	
	@FindBy(xpath="//*[text()='Companies']")
	WebElement company;
	
	@FindBy(xpath="//*[contains(text(),'New Company')]")
	WebElement createCompanyLink;
	
	
	//2  actions on WebElements
	public void logout() {
		logoutBtn.click();
	}
	
	public NewContactPage clickOnNewContact() {
		//Utility.mouseOver(createNewContactLink);
		Actions act = new Actions(driver);
		act.moveToElement(contacts).build().perform();
		createNewContactLink.click();
		return new NewContactPage();
	}
	
	public void clickOnCompany() {
		Actions act= new Actions(driver);
		act.moveToElement(company).build().perform();
	}
	
	//3 we will use pageFactory class to initialize web elements
	
	public HomePage () {
		PageFactory.initElements(driver, this);
	}
}
