package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactLookupImg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	
	//business library
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCreateContactsLookupImage()
	{
		createContactLookupImg.click();
	}
}
