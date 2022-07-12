package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class ScreenShot_Program extends TestBase{

	public static void Screen(String name) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Admin\\eclipse-workspace\\Velocity_FrameWork\\ScreenShots\\"+name+".jpeg");
		FileHandler.copy(source, dest);
		
	}
}
