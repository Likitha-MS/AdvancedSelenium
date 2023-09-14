package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateContact {

	public static void main(String[] args) {
		//Launch browser
		WebDriver driver = new FirefoxDriver();
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
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yuji");

		//Click save
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		//Verify if Organization is created
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains("Yuji"))
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
	}

}
