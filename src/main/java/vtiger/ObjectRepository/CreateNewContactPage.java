package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookupImg;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookupImg() {
		return orgNameLookupImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//business library
	/**
	 * This method will create contact with mandatory fields 
	 * @param LASTNAME
	 */
	public void createContact(String LASTNAME) 
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * THis method will create Contact using Organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 * @throws InterruptedException
	 */
	public void createContact(WebDriver driver, String LASTNAME, String ORGNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgNameLookupImg.click();
		switchToWindow(driver, "Accounts"); //Accounts is the partial title in child window
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		//search for newly created orgname using dynamic xpath (we can't use findby annotation for dynamic element)
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
}
