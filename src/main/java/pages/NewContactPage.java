package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NewContactPage extends TestBase {

	
	// web repository
	
	@FindBy (xpath="//*[contains(text(),'Contact Information']")
	WebElement contactPageTxt;
	
	
	@FindBy(id="first_name")
	WebElement FirstNameTxtBox;
	
	@FindBy(id="surname")
	WebElement LastNameTxtBox;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[2]/td[1]/table/tbody/tr[8]/td[2]/input[3]")
	WebElement CompanyNameTxtBox;
	
	@FindBy(id="mobile")
	WebElement MobileTxtBox;
	
	@FindBy(name="address_title")
	WebElement AddressTitleBox;
	
	@FindBy(xpath="//*[@id=\'contactForm\']/table/tbody/tr/td/input[2]")
	WebElement saveBtn;
	

	//2 actions
	
	public String getContactPageTxt() {
		String txt= contactPageTxt.getText();
		return txt;
	}
	
	public void createNewContactPage(String FN, String LN, String compName, String mob, String add) {
		 FirstNameTxtBox.sendKeys(FN);
		 LastNameTxtBox.sendKeys(LN);
		 CompanyNameTxtBox.sendKeys(compName);
		 MobileTxtBox.sendKeys(mob);
		 AddressTitleBox.sendKeys(add);
		 saveBtn.click();
	}
	
	    public NewContactPage () {
		PageFactory.initElements(driver, this);
	}
	
}
