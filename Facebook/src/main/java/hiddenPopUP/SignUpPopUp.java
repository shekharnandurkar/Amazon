package hiddenPopUP;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPopUp 
{

	@FindBy (xpath="//input[@name='firstname']")
	WebElement firstname;
	
	@FindBy (xpath="//input[@name='lastname']")
	WebElement lastname;
	
	@FindBy (xpath="//input[@name='reg_email__']")
	WebElement email;
	
	@FindBy (xpath="//input[@aria-label='New password']")
	WebElement password	;
	
	@FindBy (xpath="//select[@id='day']")
	WebElement day;
	
	@FindBy (xpath="//select[@id='month']")
	WebElement	month;	
	
	@FindBy (xpath="//select[@id='year']")
	WebElement year	;
	
	@FindBy (xpath=" //input[@value='2']")
	WebElement male	;
	
	@FindBy (xpath=" //input[@value='1']")
	WebElement female	;
	
	@FindBy (xpath=" //input[@value='3']")
	WebElement custom;	

	@FindBy (xpath=" (//button[@type='submit'])[2]")
	WebElement signup;
	
    WebDriverWait wait;
   // WebDriver driver;
	
	public SignUpPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	public void sendSignupDetails() {
		wait.until(ExpectedConditions.visibilityOf(firstname));
		firstname.sendKeys("shekhar");
		lastname.sendKeys("nandurkar");
		email.sendKeys("shekharnandurkar98@gmai.com");
		password.sendKeys("Shekhar@1998");
	}
	
	public void click() {
		male.click();
		signup.click();
	}
	public  void selectDropdown() {
		
		Select select=new Select(day);
		select.selectByVisibleText("26");
		 select=new Select(month);
		select.selectByVisibleText("Feb");
		 select=new Select(year);
		select.selectByVisibleText("1998");
	}
	
}
