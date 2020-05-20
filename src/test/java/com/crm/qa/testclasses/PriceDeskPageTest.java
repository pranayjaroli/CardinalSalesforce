package com.crm.qa.testclasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cardinal.qa.Base.Base;
import com.cardinal.qa.classes.AccountSearhAndCreateQuote;
import com.cardinal.qa.classes.ContactPage;
import com.cardinal.qa.classes.Homepage;
import com.cardinal.qa.classes.LoginPage;
import com.cardinal.qa.classes.PriceDeskPage;
import com.cardinal.qa.classes.UserLogin;

public class PriceDeskPageTest extends Base
{
  
	public AccountSearhAndCreateQuote create;
	public Homepage homepage;
	public LoginPage login;
	public ContactPage contact;
	public UserLogin log;
	public PriceDeskPage page;
	
	
	public PriceDeskPageTest()
	{
		super();
	}
	
	@BeforeMethod
    @Parameters("browser")
    public void setup(String browser)
    {
    	super.initialization(browser);
    	login    =   new LoginPage();
    	create   =   new AccountSearhAndCreateQuote();
		
		homepage =   new Homepage();
		log      =   new UserLogin();
		page     =   new PriceDeskPage();
		
		
		
		homepage = login.dologin();
		homepage.switchToSalesForce();
		
		Assert.assertEquals(homepage.verifyHomePageTitle(), "Salesforce - Unlimited Edition", "Homepage title is not correct");
		homepage.inputText(prop.getProperty("salesrep"));
		
		log.clickOnUser();
		log.clickOnDropDown();
		log.clickOnUserDetail();
		log.clickOnLogin();
		
		String username = log.verificationOfUser();
		username = username.replace(" ", "");
		System.out.println(username);
		Assert.assertEquals(username, prop.getProperty("salesrep"));
		
		
    }
	
	@Test
	public void tableTest()
	{
		page.table();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
