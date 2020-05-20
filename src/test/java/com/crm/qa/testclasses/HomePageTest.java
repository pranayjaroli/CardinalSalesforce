package com.crm.qa.testclasses;

//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cardinal.qa.Base.Base;
import com.cardinal.qa.classes.AccountPage;
import com.cardinal.qa.classes.ContactPage;
import com.cardinal.qa.classes.Homepage;
import com.cardinal.qa.classes.LoginPage;

public class HomePageTest extends Base
{
    
	public LoginPage loginpage;
	public Homepage homepage;
	public ContactPage contact;
	public AccountPage account;
	public HomePageTest()
    {
    	super();
    }
    
	@BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception
    {
		super.initialization(browser);
		loginpage = new LoginPage();
		homepage = loginpage.dologin();
		homepage  = new Homepage();
		Thread.sleep(20000);
    	
    }
	
	@Test(enabled=false)
    public void verifyHomePageTitleTest() throws Exception
    {
		String title = homepage.switchToSalesForce();
		if(title.equals("Salesforce - Unlimited Edition"))
		{
				System.out.println("right page");
		}
		
		else
		{
			System.out.println("title is not correct");
		}
    }
	
    @Test
    public void clickOnContactPageTest() throws Exception
    {	
    	    String title = homepage.switchToSalesForce();
    		if(title.equals("Salesforce - Unlimited Edition"))
    		{
    				contact = homepage.clickOnContactPage();
    		}
    		
    		else
    		{
    			System.out.println("title is not correct");
    		}
    }
    
    @Test(enabled = false)
    public void clickOnAccountPageTest() throws Exception
    {
    	String title = homepage.switchToSalesForce();
		if(title.equals("Salesforce - Unlimited Edition"))
		{
				account = homepage.clickOnAccountPage();
		}
		
		else
		{
			System.out.println("title is not correct");
		}
    }
    
}
