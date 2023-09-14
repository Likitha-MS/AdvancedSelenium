package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "getData")
	public void addProductToCart(String name, String model, int price)
	{
		System.out.println(name+" - "+model+" - "+price);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{                  //[][] is //row//column
		Object[][] data = new Object[4][3]; // 3 sets of data with 2 fields
		data[0][0] = "Samsung";
		data[0][1] = "A80";
		data[0][2] = 15000;
		
		data[1][0] = "Vivo";
		data[1][1] = "H56";
		data[1][2] = 12000;
		
		data[2][0] = "Apple";
		data[2][1] = "i15";
		data[2][2] = 45000;
		
		data[3][0] = "Moto";
		data[3][1] = "U85";
		data[3][2] = 18654;
		
		return data;
	}
}
