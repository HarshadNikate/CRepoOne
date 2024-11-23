package tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.SearchPage;
import util.Utilities;

public class Search {
	
	public WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setTup() {
		
		prop=Utilities.loadPropertiesFiles();
		
String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
	         driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			 driver = new EdgeDriver();
		}
		else if(browserName.equals("safari"))
		{
			  driver = new SafariDriver();
		}
		else if(browserName.equals("ie"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("AppURL"));
	}
	
	@Test(priority=1)
	public void verifySearchWithExistingProduct()
	{
		LandingPage landingpage=new LandingPage(driver);
		landingpage.enterSearchTerm(prop.getProperty("validProductSearchKey"));
		landingpage.clickOnSearchButton();
		
		SearchPage searchpage= new SearchPage(driver);
		Assert.assertTrue(!searchpage.isValidProductDisplayed());
	}
	
	@Test(priority=2,dependsOnMethods="verifySearchWithExistingProduct")
	public void verifySearchWithNonExistingProduct() {
		
		LandingPage landingpage=new LandingPage(driver);
		landingpage.enterSearchTerm(prop.getProperty("nonExistingProductSearchKey"));
		driver=landingpage.clickOnSearchButton();
		
		SearchPage searchpage= new SearchPage(driver);
		String ExpectedNoProductMessage="There is no product that matches the search criteria.";
		Assert.assertEquals(searchpage.getNoProductSearchMessage(), ExpectedNoProductMessage);		
	}
	
	@Test(priority=3)
	public void verifySearchWithoutAnyProduct()
	{
		int i=5;
		
		if(i==5)
		{
			throw new SkipException("Intentionally skipped");
		}
		LandingPage landingpage=new LandingPage(driver);
		driver=landingpage.clickOnSearchButton();
		
		SearchPage searchpage= new SearchPage(driver);
		String ExpectedNoProductMessage="There is no product that matches the search criteria.";
		Assert.assertEquals(searchpage.getNoProductSearchMessage(), ExpectedNoProductMessage);	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
