package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

	public static WebDriver driver;
	
	public String readProperty(String value) throws IOException
	{
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Velocity_FrameWork\\src\\main\\java\\Config\\Config.properties");
		pro.load(file);
		return pro.getProperty(value);
		
	}
	
	public void initialization() throws IOException
	{
		String browserName = readProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(o);
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			FirefoxOptions o = new FirefoxOptions();
			o.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver(o);
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			EdgeOptions o =new EdgeOptions();
			o.addArguments("--disable-notifications");
			System.setProperty("webdriver.msedge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
					
		}
		driver.manage().window().maximize();
//		driver.get("https://kite.zerodha.com/");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(readProperty("url"));
		
	}
	
	public String readExcelFile(int rowNum,int colnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Velocity_FrameWork\\TestData\\TestDataFile1.xlsx");
		Sheet excelFiles = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excelFiles.getRow(rowNum).getCell(colnum).getStringCellValue();
		return value;
		
		
	}
	
}
