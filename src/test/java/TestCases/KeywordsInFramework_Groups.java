package TestCases;
// Groups :- which type of group we have to execute. if we have to execute specific TestCases the we use groups.
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class KeywordsInFramework_Groups extends TestBase {

	LoginPage login;
	@BeforeMethod (groups = {"Sanity","regression"})
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (groups = "Sanity")
	public void verifyTitleTest()
	{
		String title = login.verifytitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (groups = "regression")
	public void verifykiteLogoTest()
	{
		login.verifykiteLogo();
	}
	
	@Test (groups = "Sanity")
	public void verifyzerodhaLogoTest()
	{
		login.verifyzerodhaLogo();
	}
	
	@Test (groups = "regression")
	public void loginToAppTest() throws InterruptedException, IOException
	{
		login.loginToApp();
	}
	
	@AfterMethod (groups = {"Sanity","regression"})
	public void exit()
	{
		driver.close();
	}
	
}
