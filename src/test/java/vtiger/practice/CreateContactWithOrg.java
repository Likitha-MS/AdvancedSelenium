package vtiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrg {

	public static void main(String[] args) {
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php");
						
		//Login to vtiger
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		//Click on Contacts
		driver.findElement(By.xpath("//a[.='Contacts']")).click();

		//Click on Contacts look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
						
		//Fill the lastname field
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Satarou");

		//Click on org look up 
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		//Switch to org window
		String mainId = driver.getWindowHandle();
		System.out.println(mainId);

		Set<String> allIds = driver.getWindowHandles();
		System.out.println(allIds);

		for(String id:allIds)
		{
			if(!mainId.equals(id)) 
			{
				driver.switchTo().window(id);
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("L&T561");
				driver.findElement(By.xpath("//input[@name='search']")).click();
				driver.findElement(By.linkText("L&T561")).click();
			}
		}

		//Switch back to main window
		driver.switchTo().window(mainId);

		//Click save
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		//Verify if Organization is created
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains("Satarou"))
		{
			System.out.println("PASS");
			System.out.println(ContactHeader);
		}
		else
		{
			System.out.println("FAIL");
		}

		//Logout of the application
		WebElement AdminLogo = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(AdminLogo).perform();	
		driver.findElement(By.linkText("Sign Out")).click();	
		System.out.println("Logout Successful");

		//CLose browser
		driver.quit();

	}

}
