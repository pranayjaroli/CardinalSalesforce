package com.cardinal.qa.classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cardinal.qa.Base.Base;

public class UserLogin extends Base
{
   
   String username = prop.getProperty("username");
	
   @FindBy(xpath = "//a[@title='User Action Menu']")
   WebElement clickOnDropDown;
   
   @FindBy(xpath ="//input[@title='Login']")
   WebElement userLogin;
   
   @FindBy(xpath = " //a[text()='PEPHM PARMED028']")
   WebElement user;
   
   @FindBy(css ="ul.zen-options>li:nth-of-type(1)")
   WebElement userdetail;
   
   @FindBy(xpath = "//h1[@class='currentStatusUserName']//a[text() = 'PEPHM PARMED028']")
   WebElement userverification;
   
   public UserLogin()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void clickOnUser()
   {
	user.click();
   }
   
   public void clickOnUserDetail()
   {
   	userdetail.click();
   }
   
   public void clickOnDropDown()
   {
	   clickOnDropDown.click();
   }
   
   public void clickOnLogin()
   {
	   userLogin.click();
   }
   
   public String verificationOfUser()
   {
	   return userverification.getText();
   }
   
   
}
