package com.cardinal.qa.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import com.cardinal.qa.Base.Base;
import com.cardinal.qa.TestUtil.TestUtility;

public class ContactPage extends Base
{
    
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[1]")
	WebElement save;
	
	@FindBy(xpath = "//a[@id='con4_lkwgt' and @title='Account Name Lookup (New Window)']")
	WebElement acclookup;
	
	@FindBy(xpath = "//table[@class='list']//a")
	WebElement table;
	
	@FindBy(xpath = "//input[@id='lksrch' and @placeholder='Search...']")
	WebElement Account;
	
	@FindBy(xpath = "//input[@value=' Go! ']")
	WebElement go;
	
	@FindBy(xpath = "//input[@id='con10']")
	WebElement phone;
	
	@FindBy(id="00Ni000000EHSup")
	WebElement gender;
	
	@FindBy(xpath = "//input[@id='name_lastcon2']")
	WebElement lname;
	
	@FindBy(xpath = "//input[@id='name_firstcon2']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@name='pg:frm:j_id45:searchlistcomponent:pageBlock:j_id49:j_id50' and @value='New Contact']")
	WebElement newcontactbutton;
	
	@FindBy(id = "pg:frm:txtContactFName")
	WebElement seachcriteria;
	
	@FindBy(xpath = "//input[@title='Continue' and @value='Continue']")
	WebElement cont;
	
	@FindBy(id="p3")
	WebElement drop;
	
	@FindBy(xpath = "//input[@type='button' and @title='New']")
    WebElement newcontact;
    
    public String verifycontactpagetitle()
    {
    	return driver.getTitle();
    }
    
    
    public void clickOnNew()
    {
    	newcontact.click();
    }
    
    public void selectRecordType()
    {
    	TestUtility.selectByValue(drop, "Contact");
    }
    
    public void clickOnContinue()
    {
    	cont.click();
    }
    
    public void inputingcontactName(String name)
    {
    	seachcriteria.sendKeys(name);
    	seachcriteria.sendKeys(Keys.ENTER);
    }
    
    public void clickOnNewContactButton()
    {
    	newcontactbutton.click();
    }
    
    public void insertDataFromExcel()
    {
    	
    }
    
    //Method 1
    public void clickingOnAccountAndAccountNoFromTable(String AccountName, WebDriver driver)
	 {
	   String firstxpath = "//table[@class='list']//tbody//tr[";
	   String lastxpath  = "]//th[1]";
	   
	   int i =1;
	   
	   while(i>=1)
	   {
		   String acc = driver.findElement(By.xpath(firstxpath+i+lastxpath)).getText();
		   if(acc.equals(AccountName))
		   {
			   driver.findElement(By.xpath(firstxpath+i+lastxpath)).click();
			   i++;
			   break;
		   }
		   
	   }
		 
		 
	 }
	 
     
     //method 2
    
    public void clickingOnAccountAndAccountNoFromTable2(String AccountName, WebDriver driver)
    {
    	System.out.println("pranay");
    	TestUtility.waiting1(By.xpath("//input[@id='lksrch' and @placeholder='Search...']"), driver);
    	
    	Account.sendKeys(AccountName);
    	go.click();
    	
    	StringBuffer buf = new StringBuffer(AccountName);
    	
    	
    	driver.switchTo().defaultContent();
    	TestUtility.switchToFrame(driver, "resultsFrame");
    	
    	//driver.findElement(By.linkText(AccountName)).click();
    	List<WebElement> tab = driver.findElements(By.xpath( "//table[@class='list']//a"));
    	
    
    	System.out.println(AccountName);
    	//TestUtility.stringToCharArray(AccountName, string2, driver);
    	
    	
    	
    	
    	for(int i=0;i<tab.size();i++)
    	{
    		//System.out.println(tab.get(i).getText());
    		
    		//StringBuffer buf1 = new StringBuffer(tab.get(i).getText());
    		//if(buf1.equals(buf))	
    		{
    			boolean flag =TestUtility.stringToCharArray(AccountName, tab.get(i).getText() , driver);
    			System.out.println(flag);
    			if(flag)
    			{
    				tab.get(i).click();
    				break;
    				
    			}
    		}
    	}
    	
    	TestUtility.switchToWindow(driver, 0);
    }
    
    
    public void insertingValuesToTheFieldsUsingExcel(String f, String l, String acc , String Phone, String g)
	 {
		 fname.sendKeys(f);
		 lname.sendKeys(l);
		 
		 TestUtility.selectByValue(gender, g);
		 phone.sendKeys(Phone);
		 //TestUtility.switchToWindow(driver, 1);
		 acclookup.click();
		 
	 }
    
    public void clickOnSave()
    {
    	save.click();
    }
    
     
	 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}