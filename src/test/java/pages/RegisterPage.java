package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=0]")
	private WebElement noNewsletterOption;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreeField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	
	public void enterFirstName(String firstNameTest)
	{
		
		firstNameField.sendKeys(firstNameTest);
	}
	
	
	
	public void enterLastName(String lastNameTest)
	{
		
		lastNameField.sendKeys(lastNameTest);
	}
	
	
	
	public void enterEmail(String emailTest)
	{
		emailField.sendKeys(emailTest);
	}
	
	
	
	public void enterTelephoneNo(String telephoneTest)
	{
		
		telephonefield.sendKeys(telephoneTest);
	}
	
	
	
	public void enterPassword(String passwordTest)
	{
		
		passwordField.sendKeys(passwordTest);
	}
	
	

	public void enterConfirmPassword(String confirmPasswordTest)
	{
		
		confirmpasswordfield.sendKeys(confirmPasswordTest);
	}
	
	
	public void selectYesNewsletterOption()
	{
		yesNewsletterOption.click();
	}
	
    
    
	public void selectNoNewsletterOption()
	{
		noNewsletterOption.click();
	}
	
	
	
	public void clickOnPrivacyPolicy()
	{
		agreeField.click();
	}
	
	
	
	public WebDriver clickOnSubmitButton()
	{
		submitButton.click();
		return driver;
	}
}
