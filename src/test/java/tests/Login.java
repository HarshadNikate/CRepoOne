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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;
import util.Utilities;

public class Login {

	WebDriver driver;
	Properties prop;
	
	@BeforeMethod
	public void setTup()
	{
		
		prop =Utilities.loadPropertiesFiles();
	    
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
		LandingPage landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountDropMenu();
		landingpage.selectLoginoption();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="dataSupplier1")
	public void verifyLoginUsingValidCredentials(String email,String password)
	 {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterPassword(password);
		loginpage.clickOnLoginButton();
		
		AccountPage accountpage = new AccountPage(driver);
		accountpage.navigatedToAccountpage();
		
		Assert.assertTrue(accountpage.isUserLoggedIn());
		Assert.assertTrue(accountpage.navigatedToAccountpage());
		
	}
	
	@DataProvider(name="dataSupplier1")
	public Object[][] supplyTestDataOne()
	{
		Object[][]data= {{"bunny123@yahoo.com","12345"},{"bunnynvfkkd@gmail.com","1234"},
				{"bunnygbdhgd123h@gmail.com","12345"}};
		return data;
	}
	
	@Test(priority=2)
	public void verifyLoginUsingInValidCredentials()
	{
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateNewEmail());
		loginpage.enterPassword(prop.getProperty("InValidPassword"));
		loginpage.clickOnLoginButton();
		
		
		String ExpectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningmsg = loginpage.getWarningMessage();
	    Assert.assertTrue(actualWarningmsg.contains(ExpectedWarningMsg));
	
	}
	
	
	@Test(priority=3)
	public void verifyLoginUsingInValidEmailAndvalidPasswordCredentials()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateNewEmail());
		loginpage.enterPassword("12345");
		loginpage.clickOnLoginButton();
		
		
		String ExpectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningmsg = loginpage.getWarningMessage();
	    Assert.assertTrue(actualWarningmsg.contains(ExpectedWarningMsg));
	
	}
	
	@Test(priority=4)
	public void verifyLoginUsingValidEmailInvalidpasswordCredentials()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateNewEmail());
		loginpage.enterPassword(prop.getProperty("InValidPassword"));
		loginpage.clickOnLoginButton();
		
		String ExpectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningmsg = loginpage.getWarningMessage();
	    Assert.assertTrue(actualWarningmsg.contains(ExpectedWarningMsg));
	
	}
	
	@Test(priority=5)
	public void verifyLoginUsingWithoutCredentials()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnLoginButton();
		
		String ExpectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningmsg = loginpage.getWarningMessage();
	    Assert.assertTrue(actualWarningmsg.contains(ExpectedWarningMsg));
	
	}
	
	


}
