package TestCases;
// without Priority it will run by alphabetical order
// with giving testcase Priority it will run, how we given the sequence...
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class KeywordsInFramework_Priority extends TestBase {

	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (priority = 4)
	public void verifyTitleTest() 
	{
		String title = login.verifytitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (priority = 1)
	public void verifykiteLogoTest()
	{
		login.verifykiteLogo();
	}
	
	@Test (priority = 3)
	public void verifyzerodhaLogoTest()
	{
		login.verifyzerodhaLogo();
	}
	
	@Test (priority = 2)
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
