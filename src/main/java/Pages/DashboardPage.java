package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.errorprone.annotations.FormatMethod;

import Base.TestBase;

public class DashboardPage extends TestBase
{

	@FindBy(xpath = "//span[@class='user-id']") private WebElement avatarIcon;
	@FindBy(xpath = "//h4[@class='username']") private WebElement username;
	@FindBy(xpath = "//div[@class='email']") private WebElement email;
	@FindBy(xpath = "//button[text()='Start investing ']") private WebElement startInvestingBtn;
	@FindBy(xpath = "(//input[@type='text'])[2]") private WebElement searchStocks;
	@FindBy(xpath = "(//span[@class='tradingsymbol'])[1]") private WebElement tcsStock;
	@FindBy(xpath = "//button[text()='Create GTT ']") private WebElement createGTTBtn;
	@FindBy(xpath = "//input[@label='Trigger price']") private WebElement triggerPriceTextBox;
	@FindBy(xpath = "//input[@label='Qty.']") private WebElement qtyTextBox;
	@FindBy(xpath = "//input[@label='Price']") private WebElement priceTextBox;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]") private WebElement cancelBtn;
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyusername() throws InterruptedException
	{
//		Thread.sleep(1500);
		avatarIcon.click();
//		Thread.sleep(2000);
		return username.getText();
	}
	
	public String verifyemail() throws InterruptedException
	{
//		Thread.sleep(1500);
		avatarIcon.click();
//		Thread.sleep(2000);
		return email.getText();
	}
	
	public void placeGTTOrder() throws InterruptedException, EncryptedDocumentException, IOException
	{
//		Thread.sleep(1500);
		startInvestingBtn.click();
//		Thread.sleep(1500);
		searchStocks.sendKeys(readExcelFile(0, 0));
//		Thread.sleep(1500);
		tcsStock.click();
//		Thread.sleep(1500);
		createGTTBtn.click();
//		Thread.sleep(1500);
		triggerPriceTextBox.clear();
//		Thread.sleep(1500);
		triggerPriceTextBox.sendKeys(readExcelFile(1, 0));
//		Thread.sleep(1500);
		qtyTextBox.clear();
//		Thread.sleep(1500);
		qtyTextBox.sendKeys(readExcelFile(2, 0));
//		Thread.sleep(1500);
		priceTextBox.clear();
//		Thread.sleep(1500);
		priceTextBox.sendKeys(readExcelFile(3, 0));
//		Thread.sleep(3000);
		cancelBtn.click();
//		Thread.sleep(1500);
		
	}
	
	
}
