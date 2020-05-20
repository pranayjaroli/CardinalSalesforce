package com.cardinal.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cardinal.qa.Listener.WebEventListener;

public class Base 

{
    public static WebDriver driver;
    public static Properties prop;
    public FileInputStream stream;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener web;
    
    
    
    //constructor
    public Base()
    {
    	try
    	{      
		    	File file = new File("C:\\Users\\pranay.jaroli\\eclipse-workspace\\CardinalSalesforce\\src\\main\\java\\com\\cardinal\\qa\\config\\configuration.properties");
		    	stream = new FileInputStream(file);		    	
		    	prop = new Properties();
		    	prop.load(stream);    	
    	}
    	catch(Exception e)
    	{
    		System.out.println("entered in catch");
    		e.printStackTrace();
    	}
    	
    }
    
   
    public static void initialization(String browser)
    {
    	if(browser.equals("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", ".\\ChromeDriver\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    	
    	else if(browser.equals("firefox"))
    	{
    		System.setProperty("webdriver.firefox.driver", ".//CardinalSalesforce//Firefox//geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	
    	//Listener configuration starts
    	e_driver = new EventFiringWebDriver(driver);
    	web = new WebEventListener();
    	e_driver.register(web);
    	driver = e_driver;
    	//Listener configuration ends
    	
    	driver.manage().deleteAllCookies();
    	//driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("https://test.salesforce.com");
    }
}
