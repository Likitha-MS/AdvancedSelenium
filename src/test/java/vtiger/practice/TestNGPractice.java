package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test
	public void createCustomer()
	{
		Assert.fail();
		System.out.println("Customer Created");
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("Customer Modified");
	}
	
	@Test(dependsOnMethods = {"createCustomer", "modifyCustomer"})
	public void deleteCustomer()
	{
		System.out.println("Customer Deleted");
	}
}
