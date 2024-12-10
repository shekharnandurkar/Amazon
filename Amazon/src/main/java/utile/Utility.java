package utile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

		public static String getDatafromExcel(int b,int i) throws EncryptedDocumentException, IOException {
		    String data  ;
		    
			FileInputStream file=new FileInputStream("src//test//resources//DataSource//Test Data.xlsx");
			Workbook workbook=WorkbookFactory.create(file);
			try {
			 data=workbook.getSheet("Data").getRow(b).getCell(i).getStringCellValue();
			 System.out.println(data);
				//return data;
			}
			catch(IllegalStateException e){
				System.out.println("hii");
			
			   double value=workbook.getSheet("Data").getRow(b).getCell(i).getNumericCellValue();
			   System.out.println(value);
			
			   data=String.valueOf(value);
			   System.out.println(data);
			//	return data;
			}
			
			finally{
				file.close();
			workbook.close();
			
				
			System.out.println("hi2");
			}  
				return data;
	}
		
public static void captureScreenshot(WebDriver driver,String Testid) throws IOException {
	//Calendar cal=Calendar.getInstance();
//	Date time=cal.getTime();
 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("(dd-MM-yyyy)HH mm ss");
    String timestamp = LocalDateTime.now().format(formatter);
	// SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy-hhmmss  "); 
//	String strDate = formatter.format(time); 
	//String timestamp=time.toString().replace(":", "").replace(" ", "-");
	System.out.println(timestamp);
	TakesScreenshot t=(TakesScreenshot) driver;
	File source=t.getScreenshotAs(OutputType.FILE);	
	File destination = new File("test-output//FailedTestScreenshots//"+Testid+timestamp+".jpg");
	FileHandler.copy(source, destination);
}
}
