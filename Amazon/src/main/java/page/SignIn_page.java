package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_page {

	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement email;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continuee;
	
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signinsubmit;
	
	public
	 SignIn_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	 public void sendemail(String emai) {
		 email.sendKeys(emai);
	 }
	 public void clickContinuee() {
		 continuee.click();
	 }
	 public void sendpassword(String pass) {
		 password.sendKeys(pass);
	 }
	 public void clicksigninsubmit() {
		 signinsubmit.click();
	 }
}

