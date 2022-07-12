package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Pages.Stock_Error_Msg;
import Utility.ScreenShot_Program;

public class Stock_Error_Msg_Test extends TestBase{

	LoginPage log;
	Stock_Error_Msg st;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		log = new LoginPage();
		st = new Stock_Error_Msg();
		log.loginToApp();
	}
	
	
	@Test
	public void errorTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		st.placeGTTOrderError();	
	}
	
	@AfterMethod
	public void exit(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			ScreenShot_Program.Screen(it.getName());
		}
		driver.close();
	}
}
