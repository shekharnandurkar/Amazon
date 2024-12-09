package test;

import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browse_Pojo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import page.HomePage;
import page.Orderpage;
import page.SignIn_page;
import utile.Utility;

public class Test_2 extends Browse_Pojo{
	private WebDriver driver;
	private HomePage homepage; 
	private SignIn_page signinpage;
	private Orderpage orderpage;
	private SoftAssert softassert;
	
	
	

	@Parameters("Browser")
     @BeforeTest
     void beforeTest(String expectedBrowser) {
   	 if(expectedBrowser.equals("Chrome"))
  	 {
   	 driver= launchChromeBrowser();
 		
   	 }
   	 if(expectedBrowser.equals("Firefox"))
   	 {
  	 driver= launchFirefoxBrowser();
 		
   	 }
  	 if(expectedBrowser.equals("Edge"))
	 {
	 driver= launchEdgeBrowser();
 		
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
		
		homepage=new HomePage(driver);
		signinpage =new SignIn_page( driver);
		softassert=new SoftAssert();
		orderpage=new Orderpage(driver);
		homepage.clickSignin();
		
	}
	@BeforeMethod
	void beforeMethod() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		signinpage.sendemail(Utility.getDatafromExcel(4, 0));
		signinpage.clickContinuee();
		Thread.sleep(1000);		
		signinpage.sendpassword(Utility.getDatafromExcel(4, 1));
		signinpage.clicksigninsubmit();
	}
	
	@Test (priority=0)
	void signInverify() throws InterruptedException, IOException { 
		driver.manage().window().maximize();
	String expected ="https://www.amazon.in/?ref_=nav_ya_signin";
	//String expected="ddd";
	//Thread.sleep(30000);
	String actual=driver.getCurrentUrl();
	//SoftAssert softAssert=new SoftAssert(); 
	Assert.assertEquals(actual, expected);
//	softassert.assertEquals(actual, expected);
	
	//softassert.assertAll();
	System.out.println(actual);
	System.out.println(expected);
	if(actual.equals(expected))
	{
		Utility.captureScreenshot(driver,"T101");
	}
	else {
		Utility.captureScreenshot(driver,"a");
	}
	}                                                                                //timeOut=3000
	@Test (priority=8,dependsOnMethods= {"signInverify","orderVerifyWatch"})
	void orderVerifyMobile() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		
		homepage.clickOrders();
		orderpage.clickonOrder();
		
		//String expected=WorkbookFactory.create(new FileInputStream("C:\\Users\\bobad\\Desktop\\Test Data.xlsx")).getSheet("xpath WebElement").getRow(3).getCell(2).getStringCellValue();
	   
		String actual=orderpage.verifymobileorder();
		String expected="realme narzo 60 5G (Mars Orange,8GB+128GB) 90Hz Super AMOLED Display | Ultra Premium Vegan Leather Design | with 33W SUPERVOOC Charger";
		Assert.assertEquals(actual,expected);
		System.out.println(actual);
		System.out.println(expected);
		if(actual.equals(expected))
		{
			Utility.captureScreenshot(driver,"T102");
		}
		
	}
	
	@Test (priority=6,dependsOnMethods={"signInverify"})  //  dependsOnMethods is more power > priority 
	void orderVerifyWatch() throws IOException {
		
		homepage.clickOrders();
		orderpage.clickonOrder();
		 
		String expected="Titan Analog Gold Dial Men's Watch-NL1650YM04/NP1650YM04";
		String exp="Your Orders";
		String ac=orderpage.verifyallwatchdetails();
		String actual=orderpage.verifywatchOrder();
		String act=driver.getTitle();
		System.out.println(act);
		System.out.println(ac);
		System.out.println(actual);
		Assert.assertEquals(actual,expected);
		//SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(act, exp); 
		softassert.assertAll();
		System.out.println(actual);
		System.out.println(expected);
		if(actual.equals(expected))
		{
			Utility.captureScreenshot(driver,"T103");
		}
		
	}
	@AfterMethod  
	
	void afterMethod() throws IOException {
	//	System.out.println(actual);
		//System.out.println(expected);
		
		homepage.clickOnlogout();
	}
//    @AfterClass
//   void afterClass() {
//    homepage=null;
//signinpage =null;
//		softassert=null;
//		orderpage=null;
//	System.gc();// garbage removed jinke koi reference mai value null hai use removed kr dete hai
//		
//    	
//    } 
    @AfterTest
    void afterTest() {
    	driver.close();
    	}
    
    }

