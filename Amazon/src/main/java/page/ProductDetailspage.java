package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailspage {
	@FindBy (xpath="//h1[@id='title']")
	private WebElement productName;

	@FindBy (xpath="(//span[@class='a-price-whole'])[5]")
	private WebElement productprice;

	@FindBy (xpath="(//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCart;

	public ProductDetailspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String getProductname() {
		return productName.getText().trim();
	}
	public String getProductprice() {
		return productprice.getText().trim();
	}
	public void clickOnAddToCart() {
		addToCart.click();
	}

}
