package pom_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath="//a[contains(@aria-label,'Story')]")
	private List<WebElement> stories;
	private WebElement a;
	@FindBy (xpath="//div[@aria-label='Next items']")
	private WebElement nextStories;
	
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void viewStories() {
	 a = stories.get(2);
	String b= a.getText();
	 System.out.println(b);
	 a.click();
}
public void clickOnNextStories() {
	nextStories.click();
}
}


