package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration_Page {

	
	
	@FindBy (xpath="//input[@id='ap_customer_name']")
	private WebElement name; 
	
    @FindBy (xpath="//input[@id='ap_phone_number']")
    private WebElement phone;
    
    @FindBy (xpath="//input[@id='ap_password']")
    private WebElement password;
    
    @FindBy (xpath="//input[@id='continue']")
    private WebElement continuee;
    
    public Registration_Page(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void registrationDetails() {
    	name.sendKeys("shekhar");
    	phone.sendKeys("9552319649");
    	password.sendKeys("Vaibhav@1510");
    	continuee.click();
    }
    

	
  
    
  
    
 



	
	
}

