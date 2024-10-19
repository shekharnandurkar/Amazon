package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartDetailspage {

	@FindBy (xpath="(//div[@data-csa-c-owner='CartX'])[1]//h4")
	private WebElement firstProductName;
	
	@FindBy (xpath="((//div[@data-csa-c-owner='CartX'])[1]//span)[19]")
	private WebElement firstProductPrice;
	
	

}
