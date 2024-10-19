package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.HomePage;
import page.SignIn_page;


public class TestClass_3 {
	private WebDriver driver;
	private HomePage homepage; 
	private SignIn_page signinpage;
	SoftAssert softassert;
	@BeforeClass
	 void beforeClass() {
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/ ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@BeforeMethod
	void beforeMethod() { 
		
		homepage=new HomePage(driver);
		homepage.clickSignin();
		signinpage =new SignIn_page( driver);
		signinpage.sendemail("vbobade79@gmail.com");
		signinpage.clickContinuee();
		signinpage.sendpassword("Shekhar@1996");
		signinpage.clicksigninsubmit();
		
		
	}
		
	@Test
	void signupverify() throws InterruptedException {
		softassert=new SoftAssert();
		String expected ="https://www.amazon.in/?ref_=nav_ya_signin";
		String exp="ddd";
		Thread.sleep(20000);
		String actual=driver.getCurrentUrl();
		//SoftAssert softAssert=new SoftAssert(); 
		Assert.assertEquals(actual, expected);
		softassert.assertEquals(actual, expected);
		
		softassert.assertAll();
	}
@AfterMethod  
	
	void afterMethod() {
		 
		homepage.clickOnlogout();
	}
    @AfterClass
    void afterClass() {
     driver.close();
    }  

}
