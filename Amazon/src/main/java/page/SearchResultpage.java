package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultpage {
	@FindBy (xpath="(//div[@class='sg-col-inner'])[6]]")
	private WebElement selectFirstItem;
	
	@FindBy (xpath="(//div[@class='sg-col-inner'])[6]//h2//span")
	private WebElement titleOfFirstItem;
	
	public SearchResultpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSelectItem() {
		titleOfFirstItem.click();
	}
}
