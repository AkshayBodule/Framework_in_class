package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hard_OR_Soft_Assert_Program {

	@Test (enabled = false)
	public void hard_Assert()
	{
		// hard Assert is comparing and if any exception occur program will terminated..
		System.out.println("Hard  1");
		Assert.assertEquals(true, true);
		System.out.println("Hard 2");
		Assert.assertEquals(false, false);
		System.out.println("Hard 3");
		Assert.assertEquals(true, false);
		System.out.println("Hard 4");
	}
	
	
	@Test
	public void soft_Assert()
	{
		SoftAssert s = new SoftAssert();
		
		System.out.println("soft 1");
		s.assertEquals(false, false);
		System.out.println("soft 2");
		s.assertEquals(true, false);
		System.out.println("soft 3");
		s.assertEquals(true, true);
		System.out.println("soft 4");
		
	}
}
