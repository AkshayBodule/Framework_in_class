package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Stock_Error_Msg extends TestBase
{	
	

	@FindBy(xpath = "//span[@class='user-id']") private WebElement avatarIcon;
	@FindBy(xpath = "//h4[@class='username']") private WebElement username;
	@FindBy(xpath = "//div[@class='email']") private WebElement email;
	@FindBy(xpath = "//button[text()='Start investing ']") private WebElement startInvestingBtn;
	@FindBy(xpath = "(//input[@type='text'])[2]") private WebElement searchStocks;
	@FindBy(xpath = "(//span[@class='tradingsymbol'])[1]") private WebElement tcsStock;
	@FindBy(xpath = "//button[text()='Buy ']") private WebElement buyBtn;
	@FindBy(xpath = "//input[@label='Qty.']") private WebElement qtyTextBox; 
	@FindBy(xpath = "//input[@label='Price']") private WebElement priceTextBox;
	@FindBy(xpath = "//button[@class='submit']") private WebElement PlaceBuyBtn;
	
	public Stock_Error_Msg()
	{
		PageFactory.initElements(driver, this);
	}

	public void placeGTTOrderError() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(1500);
		startInvestingBtn.click();
		Thread.sleep(1500);
		searchStocks.sendKeys("tcs");
		Thread.sleep(1500);
		tcsStock.click();
		Thread.sleep(1500);
		buyBtn.click();
		Thread.sleep(1500);
		qtyTextBox.clear();
		Thread.sleep(1500);
		qtyTextBox.sendKeys("0");
		Thread.sleep(1500);
		priceTextBox.clear();
		Thread.sleep(1500);
		priceTextBox.sendKeys("1");
		Thread.sleep(3000);
		PlaceBuyBtn.click();
		Thread.sleep(1000);
		Alert alt = driver.switchTo().alert();
		String a =alt.getText();
		System.out.println("Error Msg = "+a);
		
	}
}
