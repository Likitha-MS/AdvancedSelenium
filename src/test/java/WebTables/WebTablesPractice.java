package WebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesPractice {

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
		
		//Click on Organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//check on all check boxes
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[1]")).click();
		
		//5th check box
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[1]")).click();
		
		//capture all the organization names and print in console
		List<WebElement> alllinks = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[3]/a"));
		
		for(WebElement link:alllinks)
		{
			
			System.out.println(link.getText());
			
		}
		
	}
}
