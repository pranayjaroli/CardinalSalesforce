package com.cardinal.qa.classes;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cardinal.qa.Base.Base;
import com.cardinal.qa.TestUtil.TestUtility;


public class Homepage extends Base
{
    public Homepage()
    {
    	System.out.println("Hi");
    	PageFactory.initElements(driver, this);
    	
    }
    
    @FindBy(xpath = "//span[@class='uiImage' and @data-aura-class='uiImage']")
    WebElement lightningimage;
    
    @FindBy(xpath = "//a[text() = 'Switch to Salesforce Classic']")
    WebElement switchtosalesforce;
    
    @FindBy(xpath = "//a[text() = 'Accounts']")
    WebElement Account;
    
    @FindBy(xpath="//a[text() = 'Contacts']")
    WebElement contact;
    
    @FindBy(xpath = "//a[@class='switch-to-lightning']")
    WebElement switch1;
    
    @FindBy(xpath = "//input[@title='Search...']")
    WebElement input;
    
    @FindBy(id="phSearchButton")
    WebElement search;
    
    
    
    public String switchToSalesForce() 
    {   
    	
    	String title1 = "";
    try
       {
    	TestUtility.waiting(lightningimage, driver);
    	boolean flag = lightningimage.isDisplayed();
    	System.out.println(flag);
    	
    	if(flag)
    	{
    		lightningimage.click();
    		switchtosalesforce.click();
    		title1 = this.verifyHomePageTitle();
    		
    	}
    
        }	
        catch(Exception e)
    	{
        	e.printStackTrace();
        	title1 = this.verifyHomePageTitle();
    		
    	}
    
    return title1;
    }
    
    public String verifyHomePageTitle()
    {
    	String homepagetitle = driver.getTitle();
    	return homepagetitle;
    }
    
    public ContactPage clickOnContactPage()
    {
    	contact.click();
    	return new ContactPage();
    }
    
    public AccountPage clickOnAccountPage()
    {
    	contact.click();
    	return new AccountPage();
    }
    
    public void inputText(String value)
    {
    	input.sendKeys(value);
    	search.click();
    	
    }
    
    
}
