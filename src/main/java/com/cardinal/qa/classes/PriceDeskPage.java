package com.cardinal.qa.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cardinal.qa.Base.Base;

public class PriceDeskPage extends Base
{
   public List<WebElement> list;
	
   @FindBy(xpath = "//input[@id='ember444']")
   WebElement dynamicserach;
   
   
   
   
   public PriceDeskPage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void table()
   {   
	   
	   list           = driver.findElements(By.xpath("//table[@class='tbl']//thead//th"));
	   String Bxpath1 = "//table[@class='tbl']//tbody//tr[" ;
	   String Axpath2 = "]//td[";
	   
	   String Bxpath3 = "//table[@class='tbl']//tbody//tr[";
	   String Bxpath4 = "]//td[";
	   String Bxpath5 = "]//input[@type='number']";
	   int i = 0;
	   int j = 0;
	   while(i<=0)
	   {
		   if(list.get(i).getText().equals("On Hand"))
		   {
			   	while(j<=0)
			   	{
			   		String num = driver.findElement(By.xpath(Bxpath1+j+Axpath2+i+"]")).getText();
			   		if(!num.equals("0"))
			   		{
			   			int k = 1+1;
			   			WebElement ele = driver.findElement(By.xpath(Bxpath3+j+Bxpath4+k+Bxpath5));
			   			ele.sendKeys("2");
			   			
			   		}
			   	j++;
			   	}
		   }
	       
		   i++;
	   }
   }
   
}