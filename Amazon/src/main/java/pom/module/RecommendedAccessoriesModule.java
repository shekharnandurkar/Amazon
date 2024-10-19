package pom.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommendedAccessoriesModule {
@FindBy (xpath="//span[@id='attach-sidesheet-view-cart-button']//input")
private WebElement cartButton;
private WebElement driver;

public RecommendedAccessoriesModule(WebDriver driver) {
PageFactory.initElements(driver, this);

}
public void goToCartPage() {
	cartButton.click();
}
}
