package com.cardinal.qa.classes;

///import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cardinal.qa.Base.Base;

public class LoginPage extends Base

{
	public LoginPage()
	
	    {
		   System.out.println("yo");
		   PageFactory.initElements(driver, this);
	    }
	
   @FindBy(xpath="//input[@id='username']")
   WebElement user;
    
   @FindBy(xpath ="//input[@id='password']")
   WebElement password;
   
   @FindBy(xpath = "//input[@id='Login']")
   WebElement log;
   
   @FindBy(xpath = "//img[@id='logo' and @alt='Salesforce' ]")
   WebElement logo;
   
   
   
   public String verifyLoginPageTitle()
   {
	    String title = driver.getTitle();
	    return title;
   }
   
   public boolean verifyloginpagelogo()
   {
	   boolean value = logo.isDisplayed();
	   return value;
   }
   
   public Homepage dologin() 
   {
	   password.sendKeys(prop.getProperty("password"));
	   user.sendKeys(prop.getProperty("username"));
	   
	   log.click();
	   
	   return new Homepage();
   }
}
