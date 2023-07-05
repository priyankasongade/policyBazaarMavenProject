package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class myAccountPagePBDyanamic 
{

	//variable declaration

	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName;
	@FindBy(className="h_l")private WebElement logoutbtn;
	@FindBy(xpath="//div[text()='Contact details']")private WebElement Contactdetails;
	@FindBy(xpath="(//input[@type='text'])[1]")private WebElement MobileNo;

	//constructor
	//constructor name and class name same
	public  myAccountPagePBDyanamic(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//methods
	//he method aashi lihaychi ki mla return actualUN bhetel
	//validate actual UN
	public String getActualUN()
	{
		Reporter.log("get Actual UN",true);
		String ActualUN = userName.getText();
		return ActualUN;	
		
	}
	public void clickonLogoutButton()
	{
		
		Reporter.log("Login Out.........",true);
		logoutbtn.click();
	}
	public void clickonContactdetails()
	{
		Reporter.log("Click On Contact details ",true);

		Contactdetails.click();
	}
	public String getActualMobileNo()
	{
		Reporter.log("get Actual MobileNo",true);
		String ActualMobileNo = MobileNo.getText();
		return ActualMobileNo;
		
		
	}
}
