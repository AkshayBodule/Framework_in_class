package TestCases;
// Invocation :- if we have to execute specific Test Case multiple times then we use invocation.
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class KeywordsInFramework_Invocation extends TestBase {

	LoginPage login;
	@BeforeMethod 
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (invocationCount = 3)
	public void verifyTitleTest()
	{
		String title = login.verifytitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (invocationCount = 5)
	public void verifykiteLogoTest()
	{
		login.verifykiteLogo();
	}
	
	@Test (invocationCount = 2)
	public void verifyzerodhaLogoTest()
	{
		login.verifyzerodhaLogo();
	}
	
	@Test (invocationCount = 1)
	public void loginToAppTest() throws InterruptedException, IOException
	{
		login.loginToApp();
	}
	
	@AfterMethod 
	public void exit()
	{
		driver.close();
	}
	
}
