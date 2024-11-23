package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver ;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountinfornmationOption;
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement SubscribeUnsubscribeNewsletterOption;
	
	@FindBy(linkText="Logout")
	private WebElement logoutoption;
	
	
	
	public boolean navigatedToAccountpage()
	{
		return editYourAccountinfornmationOption.isDisplayed();
	}
	
	
	public WebDriver clickOnSubscribeUnsubscribeNewsletterOption()
	{
		SubscribeUnsubscribeNewsletterOption.click();
		return driver;
	}
	
	
	public boolean isUserLoggedIn()
	{
		return logoutoption.isDisplayed();
	}
}
