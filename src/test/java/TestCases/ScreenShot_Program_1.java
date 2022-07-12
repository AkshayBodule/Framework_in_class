package TestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.ScreenShot_Program;

public class ScreenShot_Program_1 extends TestBase {

	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test 
	public void verifyTitleTest()
	{
		String title = login.verifytitle();
		Assert.assertEquals("1Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test 
	public void verifykiteLogoTest()
	{
		login.verifykiteLogo();
	}
	
	@Test
	public void verifyzerodhaLogoTest()
	{
		login.verifyzerodhaLogo();
	}
	
	
	@AfterMethod
	public void exit(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			ScreenShot_Program.Screen(it.getName());
		}
		driver.close();
	}
	
}
