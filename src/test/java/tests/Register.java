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
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.AccountSucessPage;
import pages.LandingPage;
import pages.NewsletterSubscriptionPage;
import pages.RegisterPage;
import util.Utilities;

public class Register {
	
   public WebDriver driver;
	Properties prop;
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void setTup()
	{
		
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
		
		LandingPage landingpage= new LandingPage(driver);
		landingpage.clickOnMyAccountDropMenu();
		landingpage.selectRegisterOption();
		
		
	}

	@Test(priority=1)
	public void verifyRegisteringAccountUsingMandatoryFields() {
		// TODO Auto-generated method stub
		
		RegisterPage registerpage= new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterLastName(prop.getProperty("LastName"));
		registerpage.enterEmail(Utilities.generateNewEmail());
		registerpage.enterTelephoneNo(prop.getProperty("Telephone"));
		registerpage.enterPassword(prop.getProperty("Validpassword"));
		registerpage.enterConfirmPassword("123456");
		registerpage.clickOnPrivacyPolicy();
		registerpage.clickOnSubmitButton();
		
	
		AccountSucessPage accsucesspage = new AccountSucessPage(driver);
		Assert.assertTrue(accsucesspage.isLogOutOptionAvailable());
		Assert.assertTrue(accsucesspage.isAccountSucesspageDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsfour ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		
		String actualProperDetails = accsucesspage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsfour));
		
		accsucesspage.clickOnContinueButton();
		
		AccountPage accountpage= new AccountPage(driver);
		
		
		Assert.assertTrue(accountpage.navigatedToAccountpage());
		
		}
	
	@Test(priority=2)
	public void verifyRegisteringAccountUsingAllFields()
	{
		
		RegisterPage registerpage= new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterLastName(prop.getProperty("LastName"));
		registerpage.enterEmail(Utilities.generateNewEmail());
		registerpage.enterTelephoneNo(prop.getProperty("Telephone"));
		registerpage.enterPassword("123456");		
		registerpage.enterConfirmPassword("123456");
		registerpage.selectYesNewsletterOption();
		registerpage.clickOnPrivacyPolicy();
		registerpage.clickOnSubmitButton();
		
		AccountSucessPage accsucesspage = new AccountSucessPage(driver);
		Assert.assertTrue(accsucesspage.isLogOutOptionAvailable());
		
		accsucesspage.isAccountSucesspageDisplayed();
		
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsfour ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		
		
		String actualProperDetails = accsucesspage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsfour));
		
		accsucesspage.clickOnContinueButton();
		AccountPage accountpage= new AccountPage(driver);
		accountpage.navigatedToAccountpage();		
		
	}
	
	@Test(priority=3)
	public void verifyRegistrationUsingSayingYesToNewsletter()
	{
		
		
		RegisterPage registerpage= new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterLastName(prop.getProperty("LastName"));
		registerpage.enterEmail(Utilities.generateNewEmail());
		registerpage.enterTelephoneNo(prop.getProperty("Telephone"));
		registerpage.enterPassword("123456");		
		registerpage.enterConfirmPassword("123456");
		registerpage.selectYesNewsletterOption();
		registerpage.clickOnPrivacyPolicy();
		registerpage.clickOnSubmitButton();
		
		AccountSucessPage accsucesspage = new AccountSucessPage(driver);
		Assert.assertTrue(accsucesspage.isLogOutOptionAvailable());
		accsucesspage.isAccountSucesspageDisplayed();
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsfour ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		
		String actualProperDetails = accsucesspage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsfour));
		
		accsucesspage.clickOnContinueButton();
		
		AccountPage accountpage = new AccountPage(driver);
		accountpage.clickOnSubscribeUnsubscribeNewsletterOption();
		
		NewsletterSubscriptionPage newslettersubscription = new NewsletterSubscriptionPage(driver);
		
		Assert.assertTrue(newslettersubscription.isYesNewsLetterOptionSelected());
	  
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	}
	
	@Test(priority=4,enabled=false)
	public void verifyRegistrationUsingSayingNoToNewsletter()
	{
	    
		RegisterPage registerpage= new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterLastName(prop.getProperty("LastName"));
		registerpage.enterEmail(Utilities.generateNewEmail());
		registerpage.enterTelephoneNo(prop.getProperty("Telephone"));
		registerpage.enterPassword("123456");		
		registerpage.enterConfirmPassword("123456");
		registerpage.selectNoNewsletterOption();
		registerpage.clickOnPrivacyPolicy();
		registerpage.clickOnSubmitButton();
		
		AccountSucessPage accsucesspage = new AccountSucessPage(driver);
		Assert.assertTrue(accsucesspage.isLogOutOptionAvailable());
		accsucesspage.isAccountSucesspageDisplayed();
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsfour ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		
		String actualProperDetails = accsucesspage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsfour));
		
        accsucesspage.clickOnContinueButton();
		
		AccountPage accountpage = new AccountPage(driver);
		accountpage.clickOnSubscribeUnsubscribeNewsletterOption();
		NewsletterSubscriptionPage newslettersubscription = new NewsletterSubscriptionPage(driver);
		Assert.assertTrue(newslettersubscription.isNoNewsLetterOptionSelected());
	
	}
	
	

}
