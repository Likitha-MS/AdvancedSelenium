package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	//business library
	/**
	 * This method will click on create organization look up image
	 */
	public void clickOnCreateOrgLookUpImage()
	{
		createOrgLookupImg.click();
	}
	
	
}
