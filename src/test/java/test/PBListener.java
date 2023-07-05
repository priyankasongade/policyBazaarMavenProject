package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Base.Base;
import Utility.Utility;

public class PBListener extends Base implements ITestListener//diver sathi extends base class
{
	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log("This "+result.getName()+" Started..........", true);
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{//TC pass zalyavr pn SC sathi
		try 
		{
			Utility.takeScreenShot(driver,result.getName());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Reporter.log("This "+result.getName()+" method run successfully......thanku", true);
	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		 try 
		 {
			Utility.takeScreenShot(driver,result.getName());// diver bhetla 
			//aata Fail TC pass krnyasathi object name.getname() use
		 } 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
		Reporter.log("This "+result.getName()+" method skip check dependsOn method", true);

	}
		

}
