package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath = "//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy(xpath = "//input[@id='userid']") private WebElement userIdTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextBox;
	@FindBy(xpath = "//button[@type='submit']") private WebElement loginBtn;
	@FindBy(xpath = "//input[@id='pin']") private WebElement pinTextBox;
	@FindBy(xpath = "//button[@type='submit']") private WebElement continueBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle()
	{
		return driver.getTitle();	
	}
	
	public void verifykiteLogo()
	{
		kiteLogo.isDisplayed();
	}
	
	public void verifyzerodhaLogo()
	{
		zerodhaLogo.isDisplayed();
	}
	
	public void loginToApp() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		userIdTextBox.sendKeys(readProperty("username"));
		Thread.sleep(2000);
		passwordTextBox.sendKeys(readProperty("password"));
		Thread.sleep(2000);
		loginBtn.click();
		Thread.sleep(2000);
		pinTextBox.sendKeys(readProperty("pin"));
		Thread.sleep(2000);
		continueBtn.click();
		Thread.sleep(3000);
		
	}
	
}
