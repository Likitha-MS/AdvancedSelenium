package EncryptDecrypt;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EncryptAndDcrypt {

	public static void main(String[] args) {
		String encryptedUsename = new String(Base64.getEncoder().encode("admin".getBytes()));
		String encryptedPassword = new String(Base64.getEncoder().encode("admin".getBytes()));
		
		System.out.println(encryptedUsename);
		System.out.println(encryptedPassword);
		
		String decryptedUsername = new String(Base64.getDecoder().decode(encryptedUsename.getBytes()));
		String decryptedPassword = new String(Base64.getDecoder().decode(encryptedPassword.getBytes()));

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(decryptedUsername);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(decryptedPassword);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	}

}
