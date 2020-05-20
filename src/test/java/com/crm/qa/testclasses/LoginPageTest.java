package com.crm.qa.testclasses;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cardinal.qa.Base.Base;
import com.cardinal.qa.classes.Homepage;
import com.cardinal.qa.classes.LoginPage;

public class LoginPageTest extends Base

{
	public LoginPage login;
	public Homepage homepage;
	
	
	public LoginPageTest()
    {
    	super();
    }
	 
	
	
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser)
    {
		super.initialization(browser);
		login = new LoginPage();
    	
    	
    }
    
    @Test(priority=2 , enabled = false)
    public void verifyLoginPageTitleTest()
    {
    	 String title = login.verifyLoginPageTitle();
         Assert.assertEquals(title, "Login | Salesforce" , "title of the login page is not same");
    }
    
    @Test(priority = 3 , enabled = false)
    public void verifyloginpagelogoTest()
    {
    	Assert.assertTrue(login.verifyloginpagelogo());
    }
    
    
    @Test
    public void dologinTest() throws Exception
    {
        
    	homepage = login.dologin();
    }
}
