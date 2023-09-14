package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void test()
	{
		System.out.println("Start");
		Assert.assertEquals("a", "b");
		System.out.println("Stop");
	}
	
	@Test
	public void test2()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
//		Assert.assertEquals(false, true);//hard assert stops execution if its failed

		System.out.println("Step 2");	
		
		sa.assertTrue(false);
		
		System.out.println("Step 3");
		Assert.assertEquals(false, true);
		System.out.println("Step 4");
		
		sa.assertAll(); // all errors will be logged, use after all in the end 
	}
}
