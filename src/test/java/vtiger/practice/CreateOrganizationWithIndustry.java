package vtiger.practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) {
		Random r = new Random();
		int random = r.nextInt(1000);
		
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php");
		
		//Login to vtiger
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//Click on Organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Fill in Org name
		String OrgName = "L&T"+random;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//Select from Industry Dropdown
		WebElement industry = driver.findElement(By.name("industry"));
		Select s = new Select(industry);
		s.selectByValue("Chemicals");
		
		//Click Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verify if Organization is created
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(OrgName))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
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
