package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactsHeader;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsHeader() {
		return contactsHeader;
	}
	
	//business library
	/**
	 * This method will return the header text 
	 * @return
	 */
	public String getCntHeader()
	{
		return contactsHeader.getText();
	}
}
