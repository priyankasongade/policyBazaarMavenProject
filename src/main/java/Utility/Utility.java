package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
 //commonly use methods
	//wait
	//data read from XL sheet
	//Scrolling
	//Screenshot
	//all methods static calling time not create object 
	public static void takeScreenShot(WebDriver driver,String FileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//nullpointerexception mhnun driver static kra base class mdhe
		File dest = new File("/home/ubuntu/eclipse-workspace/Java18Feb/policyBazaarMaven/ScrrenShots"+FileName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("takeing scrrenshot",true);
		Reporter.log("ScreenShot path is......."+dest,true);//SC cha path console la disava mahnun add kela dest path
	}
	public static void ScrollIntoView(WebDriver driver,WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scollIntoView(true)",element);
		Reporter.log("scrolling into view ",true);
	}
	public static String readDataFromExcel(int rowNo,int cellNo) throws  IOException
	{
		FileInputStream myfile=new FileInputStream("/home/ubuntu/Desktop/Priyanka/policyBazaarTestData.xlsx");
		Reporter.log("Reading data From ExcelSheet RowNois "+rowNo+" CellNo is "+cellNo,true);
		String value = WorkbookFactory.create(myfile).getSheet("sheet1").getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	public static void wait(int waitTime) throws InterruptedException
	{
		Reporter.log("waiting for"+waitTime +" Mili sec", true);
		Thread.sleep(waitTime);

	}
	public static String readDataFromPropertyFile(String Key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream("/home/ubuntu/eclipse-workspace/selenium18Feb/PBPropertyFile.properties");
		prop.load(myfile);
		String value = prop.getProperty(Key);
		Reporter.log("Reading Data "+Key+" From propertyFile", true);
		return value;
		
	}
	
	
}
