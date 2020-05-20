package com.crm.qa.testclasses;

import java.util.ArrayList;

import java.util.Iterator;

//import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cardinal.qa.Base.Base;
import com.cardinal.qa.TestUtil.TestUtility;
import com.cardinal.qa.classes.ContactPage;
import com.cardinal.qa.classes.Homepage;
import com.cardinal.qa.classes.LoginPage;


@Listeners(com.cardinal.qa.Listener.CustomListener.class)
public class ContactPageTest extends Base 
{
	public LoginPage login;
	public Homepage homepage;
	public ContactPage contact;
	public ArrayList<Object[]> ar;
	
	public ContactPageTest()
    {
    	super();
    }
	 
	
	
	@BeforeMethod
    @Parameters("browser")
    public void setup(String browser)
    {
		super.initialization(browser);
		login = new LoginPage();
		//homepage = new Homepage();
		contact = new ContactPage();
		homepage = login.dologin();
		homepage.switchToSalesForce();
		contact = homepage.clickOnContactPage();
		
    	
    	
    }
    
    
    @Test(dataProvider = "dataFromExcel")
    public void newContactCreationAndTitle(String firstname, String lastname, String Account, String Phone , String gender) throws Exception
    {
    	String title = contact.verifycontactpagetitle();
    	Assert.assertEquals("Contacts: Home ~ Salesforce - Unlimited Edition", title , "title is not correct");
    	
    	contact.clickOnNew();
    	contact.selectRecordType();
    	
    	Assert.assertFalse(true);
    	contact.clickOnContinue();
    	contact.inputingcontactName("pranay");
    	contact.clickOnNewContactButton();
    	contact.insertingValuesToTheFieldsUsingExcel(firstname, lastname, Account, Phone, gender);
    	
    	Thread.sleep(6000);
    	TestUtility.switchToWindow(driver, 1);
    	driver.switchTo().frame("searchFrame");
    	contact.clickingOnAccountAndAccountNoFromTable2(Account, driver);
    	contact.clickOnSave();
  	
    	
     }
    
    @DataProvider
    public Iterator<Object[]> dataFromExcel()
    {
    	ArrayList<Object[]> li = TestUtility.readDataFromExcel();
       	return  li.iterator();
       	 
    }
    
    
    
    
}
