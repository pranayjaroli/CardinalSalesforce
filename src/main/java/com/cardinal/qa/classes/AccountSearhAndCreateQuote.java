package com.cardinal.qa.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cardinal.qa.Base.Base;

public class AccountSearhAndCreateQuote extends Base
{
  
  public static List<WebElement> list;	
  
  @FindBy(xpath = "(//a[text()='AMAR PHARMACY INC'])[position()=1]")
  WebElement acc;
  
  @FindBy(xpath = "//span[text()='Account Assignments']")
  WebElement accassign;
  
  @FindBy(xpath = "//input[@value='Create Quote']")
  WebElement createquote;
  
  @FindBy(xpath="//span[text()='Details']")
  WebElement details;
  
  public AccountSearhAndCreateQuote()
  {
	  PageFactory.initElements(driver, this);
  }
  
  public boolean repverification(WebDriver driver)
  {
	  boolean flag = false;
	  list = driver.findElements(By.xpath("//div[@id='0015A000025U4Hi_00N3100000GOLW2_body']//table[@class = 'list']//tbody//td"));
      for(WebElement ele : list)
      {   
    	  
    	  String text = ele.getText();
    	  text = text.replace(" ", "");
    	  System.out.println(text);
    	  if(text.equals(prop.getProperty("salesrep")))
    	  {
    		  flag = true;
    		  break;
    	  }
    	  
    	  
      }
	
  return flag; 
  }
  
  public void clickOnAccount()
  {
	  acc.click();
	  details.click();
  }
  
  public String verifyPageTitle()
  {
	  return driver.getTitle();
  }
  
  public void clickOnCreateQuote()
  {
	  createquote.click();
  }
  
  
}
