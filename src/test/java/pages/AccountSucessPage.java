package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage {

	WebDriver driver;
	
	public AccountSucessPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(linkText="Success")
	private WebElement accountSucessBreadCrumbOption;
	
	@FindBy(id="content")
	private WebElement sucessPageContent;
	
	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	
	
	public boolean isLogOutOptionAvailable()
	{
		return logout.isDisplayed();
	}
	
	
	public boolean isAccountSucesspageDisplayed()
	{
		return accountSucessBreadCrumbOption.isDisplayed();
	}
	
	
	public String getProperContentDisplayed()
	{
		return sucessPageContent.getText();
	}
	
	
	public WebDriver clickOnContinueButton()
	{
		continueButton.click();
		return driver;
	}
	
}
