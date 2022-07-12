package TestCases;
// enabled :- it is use for which test case we want to execute or not execute by giving true or false parameters.
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (enabled = false)
	public void verifyTitleTest()
	{
		String title = login.verifytitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (enabled = false)
	public void verifykiteLogoTest()
	{
		login.verifykiteLogo();
	}
	
	@Test (enabled = false)
	public void verifyzerodhaLogoTest()
	{
		login.verifyzerodhaLogo();
	}
	
	@Test
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
