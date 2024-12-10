package pom_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (xpath="//input[@name='email']")
	private WebElement username;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy (xpath="//a[text()='Create new account']")
	private WebElement create;
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	 public void sendUserName() {
		username.sendKeys("vbobade79@gmail.com");
	}
	
	public void enterpassword() {
		password.sendKeys("Vaibhav@1510");
	}
	public void clickOnLoginButton() {
		login.click();
	}
	public void clickOnCreate() {
		create.click(); 
	}
	
	public void login() 
	{
		username.sendKeys("vbobade79@gmail.com");
		password.sendKeys("Vaibhav@1510");
		login.click();
		
			
		
	}
 
	
}
