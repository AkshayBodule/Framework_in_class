package TestCases;
// dependsOnMethods:- we dependent any method on other method.
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class KeywordsInFramework_Depends_On_Methods extends TestBase {

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
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (dependsOnMethods = "verifyTitleTest")
	public void verifykiteLogoTest()
	{
		login.verifykiteLogo();
	}
	
	@Test (dependsOnMethods = "verifyTitleTest")
	public void verifyzerodhaLogoTest()
	{
		login.verifyzerodhaLogo();
	}
	
	@Test (dependsOnMethods = "verifyTitleTest")
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
