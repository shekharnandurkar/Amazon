package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderpage {

	@FindBy (xpath="//span[@id='a-autoid-1-announce']")
	private WebElement orderduration;
	
	@FindBy (xpath="//a[contains(text(),'   2023')]")
	private WebElement orderyear;
	
	@FindBy (xpath="//a[contains(text(),'realme narzo 60 5G (Mars Orange,8GB+128GB)')]")
	private WebElement mobileorder;
	

	@FindBy (xpath="//div[contains(text(),'Titan Analog Gold ')]")
	private WebElement watchOrder;
	
	

	@FindBy (xpath="//div[@class='a-fixed-right-grid a-spacing-small']")
	private WebElement allwatchdetail;
	
	public Orderpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickonOrder() {
		orderduration.click();
		orderyear.click();
		
	}
	public String verifymobileorder() {
		
		String actual=mobileorder.getText();
		return actual ;
	}
	public String verifywatchOrder() {
		String actual=watchOrder.getText();
		return actual;
	}
	public String verifyallwatchdetails() {
		String ac=watchOrder.getText();
		return ac;
	}
}
