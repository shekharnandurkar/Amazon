package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath="//span[text()='Hello, sign in']")
	private WebElement signin;
	
	@FindBy (xpath="//span[text()='Sign Out']")
	private WebElement logout;
	
	@FindBy (xpath="(//a[text()='Start here.'])[1]")
	private WebElement starthere;
	
	@FindBy (xpath="//span[text()='Your Orders']")
	private WebElement order;
	
	@FindBy (xpath="//span[text()='Account & Lists']")
	private WebElement account;
	

	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;
	

	@FindBy (xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	
	
	Actions actions;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions=new Actions(driver);
	}
	public void clickSignin() {
		signin.click();
	}
	public void mousehouring() {
		actions.moveToElement(signin).perform();
	}
	public void clickStarthere() {
		actions.moveToElement(account).perform();
		order.click();
	}
	public void clickOrders() {
		actions.moveToElement(account).perform();
	    order.click();
	    
	}
	public void clickOnlogout() {
		actions.moveToElement(account).perform();
		logout.click();
	}
	public void enterProductName(String productName) {
		searchTextBox.sendKeys(productName);
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
}
