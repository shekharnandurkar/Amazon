package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_Class.HomePage;
import pom_Class.LoginPage;

public class Test_1 {
	private LoginPage loginpage;
	private HomePage homepage;
	
	WebDriver driver=new ChromeDriver();
@BeforeClass
 void beforeClass() {
 
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");	
	driver=new ChromeDriver(option);
}
@BeforeMethod
void beforeMethod() {


	driver.get("https://www.facebook.com/");
	 loginpage=new LoginPage(driver);
	loginpage.login();
}
@Test
void test1() {
	 homepage=new HomePage(driver);
	homepage.viewStories();
}

@AfterMethod
void afterMethod() {
	
}
@AfterClass
void afterClass() {
	//driver.close();
}
}
