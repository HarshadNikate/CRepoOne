package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String generateNewEmail()
	{
		Date date = new Date();
		String datestring = date.toString();
	    String dateStringWithoutSpace = datestring.replaceAll(" ", "");
	    String dateStringWithoutSpaceAndColon = dateStringWithoutSpace.replaceAll(":", "");
	    String emailWithTimeStamp = dateStringWithoutSpaceAndColon+"@gmail.com";
	    return emailWithTimeStamp;
	}
	
	public static Properties loadPropertiesFiles()
	{
		Properties prop = null;
		
		try {
			 prop = new Properties();
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ApplicationData.properties");
			prop.load(fr);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return prop;
	}

	public static String takesScreenShot(WebDriver driver,String testName)
	{
		TakesScreenshot tsDriver = (TakesScreenshot)driver;
		File screenshotFile = tsDriver.getScreenshotAs(OutputType.FILE);
		
		String screenshotFilePath=null;
		
		try {
			screenshotFilePath=System.getProperty("user.dir")+"\\target\\screenshots"+testName+".png";
			FileHandler.copy(screenshotFile, new File(screenshotFilePath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return screenshotFilePath;
		
	}
}
