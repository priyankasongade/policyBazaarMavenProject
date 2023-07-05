package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Base;
import POM.LoginPagePBDyanamic;
import POM.myAccountPagePBDyanamic;
import Utility.Utility;

 //@Listeners(PBtest.PBListener.class)=use xml
public class PB_TC1234_validateUNUsePropertyFile extends Base//driver declare in base class
{
	//login & myaccount  all method nonstatic mahnun create object for calling
	//jevdhe pomclass tevdhya page che object declare
	//create multiple objects declare
	//driver acsscs honyasathi  base class mdhe driver protected kraycha 
	//protected=scope unother package
	LoginPagePBDyanamic login;
	myAccountPagePBDyanamic myacc;
	String TCID="PB_TC_123";
	
	@BeforeClass
	public void launchPolicyBazaar() throws InterruptedException, IOException
	{
		Utility.wait(1000);//utility class use for wait
		launchBrowserusingPropertyFile();//base class method launchBrowser
		
		//object initilise
		//jevdhe pom class tevdhe object initilise
		login=new LoginPagePBDyanamic(driver);
		myacc=new myAccountPagePBDyanamic(driver);
		
	}
	@BeforeMethod
	public void signIntopolicyBazaar() throws InterruptedException, IOException
	{
		//all methods call here in loginpage class
		Utility.wait(1000);
		login.ClickOnHomePageSignInBtn();
		Utility.wait(1000);
		login.entermobileno(Utility.readDataFromPropertyFile("MobNo"));
		Utility.wait(1000);
		login.ClickOnSignInWithPassword();
		Utility.wait(1000);
		login.enterPassword(Utility.readDataFromPropertyFile("pwd"));
		Utility.wait(1000);
		login.clicksignInButton();
		Utility.wait(1000);
		
		login.ClickOnMyAccount();
	    Utility.wait(1000);
	    
	    login.ClickOnMyProfile();
		Utility.wait(1000);
		
		//open nwe window use childBrowser Popup
		Set<String> allpageid = driver.getWindowHandles();
		//set of String convert to arraylist/List(use upcasting)
		List<String>al=new ArrayList<>(allpageid);
		//String mainpageid = al.get(0);
		String chaildpageid = al.get(1);
		driver.switchTo().window(chaildpageid);
		Reporter.log("switch focus main page to child page", true);
		Utility.wait(3000);
	}	
  @Test
  public void validateUN() throws IOException, InterruptedException 
  {
	  String actualUN = myacc.getActualUN();
	  String expectedUN = Utility.readDataFromPropertyFile("UN"); 
	  
	  AssertJUnit.assertEquals(expectedUN,actualUN);//OR
	  
	  //Assert.assertEquals(myacc.getActualUN(),Utility.readDataFromExcel(0, 2),"ActualUN and ExpectedUn are NotMatching TC Fail");
	  //i want to take screen shot of Validate UN page
	 // Utility.takeScreenShot(driver,actualUN+" "+TCID);this code wright in PBListener
	  
  }
//  @Test
//  public void validateMobileNo() throws IOException, InterruptedException
//  {
//	  myacc.clickonContactdetails();
//	  Utility.wait(1000);
//	  String actualMOB = myacc.getActualMobileNo();
//	  String ExpMOB=Utility.readDataFromPropertyFile("MobNo");
//	  Assert.assertEquals(ExpMOB,actualMOB);
//	  Utility.takeScreenShot(driver,actualMOB+" "+TCID);
//  }
  
  @AfterMethod
  public void LogountFromPolicyBazaar() throws InterruptedException
  {
	  myacc.clickonLogoutButton();
	  
	 //Utility.wait(1000);//clickonlogout method mdhe wait use kel aahe tymule ethe nahi kahi takaych only call here
	  
  }
  @AfterClass
  public void closePolicyBazaar() throws InterruptedException
  {
	  CloseBrowser();//this method present in base package
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
