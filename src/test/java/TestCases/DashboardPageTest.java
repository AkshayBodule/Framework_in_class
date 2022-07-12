package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardPageTest extends TestBase{

	LoginPage login;
	DashboardPage dashboard;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		dashboard = new DashboardPage();
		login.loginToApp();
	}
	
	@Test (enabled = false)
	public void verifyusernameTest() throws InterruptedException
	{
		String value = dashboard.verifyusername();
		Assert.assertEquals(value,"Akshay Bodule");
	}
	
	@Test (enabled = false)
	public void verifyemailTest() throws InterruptedException
	{
		String value = dashboard.verifyemail();
		Assert.assertEquals(value,"akshaybodule@gmail.com");
	}
	
	@Test
	public void placeGTTOrderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dashboard.placeGTTOrder();
	}
	
	
	
	@AfterMethod
	public void exit()
	{
		driver.close();
	}
	
	
	
	
}
