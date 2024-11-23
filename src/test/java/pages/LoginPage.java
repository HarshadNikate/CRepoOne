package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement loginBreadCrumbOption;
	
	@FindBy(id="input-email")
	private WebElement emailaddresField;
	
	 @FindBy(id="input-password")
	 private WebElement passwordfield;
	 
	 @FindBy(xpath="//input[@value='Login']")
	 private  WebElement loginbutton;
	 
	 @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	 private WebElement warningMessage;
	 
	 
	
	 
    public boolean navigatedToLoginPage()
    {
    	return loginBreadCrumbOption.isDisplayed();
    }
    
    public void enterEmailAddress(String emailText)
    {
    	emailaddresField.sendKeys(emailText);
    }
    
   
    
    public void enterPassword(String passwordText)
    {
    	passwordfield.sendKeys(passwordText);
    }
    
   
    public WebDriver clickOnLoginButton()
    {
    	loginbutton.click();
    	return driver;
    }
    
    
    public String getWarningMessage()
    {
    	return warningMessage.getText();
    }
    
   
    
    
}
