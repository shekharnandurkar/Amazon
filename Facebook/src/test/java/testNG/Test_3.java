package testNG;



//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hiddenPopUP.SignUpPopUp;
import pom_Class.LoginPage;


	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Test_3 {
		WebDriver driver =new ChromeDriver();

	@BeforeClass
	 void beforeClass() {
		
		driver.get("https://www.facebook.com/");
		
	}
	@BeforeMethod
	void beforeMethod() {

		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickOnCreate();
		
	}
	@Test
	void test1() {
		SignUpPopUp signuppopup=new SignUpPopUp(driver); 
		signuppopup.sendSignupDetails();
		signuppopup.selectDropdown();
		signuppopup.click();
	}
	
	@AfterMethod
	void afterMethod() {
		
	}
	@AfterClass
	void afterClass() {
		
       // driver.close();
		
	}
	

			

}