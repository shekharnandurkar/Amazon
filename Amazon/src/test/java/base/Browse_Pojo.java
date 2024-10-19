package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browse_Pojo {
public static WebDriver launchChromeBrowser() {
	
	WebDriver driver= new ChromeDriver();
	return driver;
}
public static WebDriver launchFirefoxBrowser() {
	
	WebDriver driver= new FirefoxDriver();
	return driver;
}
public static WebDriver launchEdgeBrowser() {
	
	WebDriver driver= new EdgeDriver();
	return driver;
}
}
