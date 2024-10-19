package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.HomePage;
import page.Registration_Page;
import page.SignIn_page;

public class Test_1 {

	WebDriver driver;
	HomePage homepage; 
	Registration_Page registrationpage;
	SignIn_page signinpage;
	 

	@Parameters("Browser")
     @BeforeTest
     void beforeTest(String expectedBrowser) {
    	 if(expectedBrowser.equals("Chrome"))
    	 {
    	 driver= new ChromeDriver();
 		
    	 }
    	 if(expectedBrowser.equals("Firefox"))
    	 {
    	 driver= new FirefoxDriver();
 		
    	 }
    	 if(expectedBrowser.equals("Edge"))
    	 {
    	 driver= new EdgeDriver();
 		
    	 }
    	 if(expectedBrowser.equals("Safari"))
    	 {
    	 driver= new InternetExplorerDriver();
 		
    	 }
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 		driver.get("https://www.amazon.in/ ");
    	 
    	 
    	 
     }
	@BeforeClass
	 void beforeClass() {
		driver= new ChromeDriver();
		homepage=new HomePage(driver);
		registrationpage=new Registration_Page(driver);
	} 
	@BeforeMethod
	void beforeMethod() { 
		
		homepage.clickStarthere();	
		
	}
		
	@Test
	void signupverify() {
		
		registrationpage.registrationDetails();
		
		
	}
	@AfterClass
	void afterClass() {
		System.gc();
	}
	@AfterTest
	void afterTest() {
		driver.quit();
	}
}
