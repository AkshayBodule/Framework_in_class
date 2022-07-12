package TestCases;
//timeout :- it is use for when we want to give any testcase execution Time Limit.
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class KeywordsInFramework_Timeout extends TestBase {

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
	
	@Test (timeOut = 2)
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
