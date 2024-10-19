package utile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

		public static String getDatafromExcel(int a,int i) throws EncryptedDocumentException, IOException {
		
			FileInputStream file=new FileInputStream("C:\\Users\\bobad\\Desktop\\Test Data.xlsx");
			String data=WorkbookFactory.create(file).getSheet("Data").getRow(a).getCell(i).getStringCellValue();
			WorkbookFactory.create(file).close();
				return data;
	}
		
public static void captureScreenshot(WebDriver driver) throws IOException {
	
	TakesScreenshot t=(TakesScreenshot) driver;
	File source=t.getScreenshotAs(OutputType.FILE);	
	File destination = new File("C:\\Users\\bobad\\Videos\\screenshot\\bhumi3.jpg");
	FileHandler.copy(source, destination);
}
}
