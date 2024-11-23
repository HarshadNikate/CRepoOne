package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterSubscriptionPage {

	WebDriver driver;


public NewsletterSubscriptionPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@type='radio'][@value=1]")
private WebElement yesNewsletteroption;

@FindBy(xpath="//input[@type='radio'][@value=0]")
private WebElement noNewsletteroption;


public boolean  isYesNewsLetterOptionSelected()
{
	return yesNewsletteroption.isDisplayed();
}

public boolean  isNoNewsLetterOptionSelected()
{
	return noNewsletteroption.isDisplayed();
}
}