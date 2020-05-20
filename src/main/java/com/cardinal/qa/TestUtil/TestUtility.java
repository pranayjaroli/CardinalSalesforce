package com.cardinal.qa.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cardinal.qa.Base.Base;

public class TestUtility

{
	
	
	
	public static WebDriverWait wait;  
    public static JavascriptExecutor exe;
    public static WebDriver driver;
    public static boolean flag = false;
    public static Select select;
    public static File file;
    public static FileInputStream input;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static Cell cell;
    public static TakesScreenshot sc;
    public static Actions ac;
	
     public static void waiting(WebElement element, WebDriver driver)
	 {   
		wait = new WebDriverWait(driver , 15);
  	    wait.until(ExpectedConditions.elementToBeClickable(element));
     }
	
	 public static void javaexecutor(WebDriver driver , WebElement element)
	 {
		 exe = (JavascriptExecutor)driver;
	     exe.executeScript("arguments[0].click();", element );
	 }
	 
	 public static void waiting1(By by , WebDriver driver)
     {   
		 wait = new WebDriverWait(driver, 15);
 	     wait.until(ExpectedConditions.visibilityOfElementLocated(by));
     }
	 
	 public static void scroll(WebElement element)
	 {
		 exe.executeScript("arguments[0].scrollIntoView(true);", element);
     }
	 
	 public static void selectByValue(WebElement element , String value)
	 {
		 select = new Select(element);
		 select.selectByVisibleText(value);
		 
	 }
	 
	 public static ArrayList<Object[]> readDataFromExcel()
	 {
		 ArrayList<Object[]> list = new ArrayList<Object[]>();
		 
		 try 
		 {
			 file  = new File("C:\\Users\\pranay.jaroli\\eclipse-workspace\\CardinalSalesforce\\src\\main\\java\\com\\cardinal\\qa\\TestData\\contact data.xlsx");
			 input =  new FileInputStream(file);
			 wb = new XSSFWorkbook(input);
			 sh = wb.getSheetAt(0);
			 
		 } 
		 catch (Exception e) 
		 {
			
			e.printStackTrace();
		 }
		 
		 int rows = sh.getPhysicalNumberOfRows();
		 int col  =  sh.getRow(0).getPhysicalNumberOfCells();
		 System.out.println(rows+" "+col);
		 //int col = sheet.getRow(0).getPhysicalNumberOfCells();
		 for(int i =1; i<rows;i++)
		 {
			     String firstname = sh.getRow(i).getCell(0).getStringCellValue();
			     System.out.println(firstname);
				 
			     String lastname  = sh.getRow(i).getCell(1).getStringCellValue();
				 System.out.println(lastname);
			     
				 String AccountLowerCase   = conversionToTextFromNumeric(i, 2);
			     String Account = new String(AccountLowerCase.toUpperCase());
			     Account.replace("//s", "");
			     //Account.append(A);
			     System.out.println(Account);
			     
			     String Phone     = conversionToTextFromNumeric(i, 3);
			     System.out.println(Phone);
			     
			     String gender    = conversionToTextFromNumeric(i, 4);
			     System.out.println(gender);
			     
			     Object[] ob = {firstname,lastname,Account,Phone,gender};
		         list.add(ob);
		 }
	  
         return list; 	 
	 }
	 
	 
	 public static void switchToWindow(WebDriver driver , int index)
	 {
		 ArrayList<String> ar = new ArrayList<String>(driver.getWindowHandles());
		 System.out.println(ar.size());
		 driver.switchTo().window(ar.get(index));
		/*
		 * for(String item: ar) { System.out.println(item);
		 * System.out.println("This is the page with title: "+driver.getTitle() + item);
		 * if(driver.getTitle().equals("Search ~ Salesforce - Unlimited Edition")) {
		 * driver.switchTo().window(item); break; }
		 * 
		 * }
		 */
		 
		 //System.out.println(ar.get(index));
		 //driver.switchTo().window(ar.get(index));
	 }
	 
	 
	 public static String conversionToTextFromNumeric(int row, int col)
	 {
		//GET CELL
         Cell cell1 = sh.getRow(row).getCell(col);   
         //SET AS STRING TYPE
         cell1.setCellType(Cell.CELL_TYPE_STRING); 
         
         return cell1.getStringCellValue();
	 }
	 
	 public static void switchToFrame(WebDriver driver , String name)
	 {
		 driver.switchTo().frame(name);
	 }
	 
	 
	 public static boolean stringToCharArray(String string1, String string2 , WebDriver driver)
	 {
		 string1 = string1.replace(" ", "");
		 string2 = string2.replace(" ", "");
		 //boolean string1.contains(string2);
		 char c[]  = string1.toCharArray();
		 char c1[] = string2.toCharArray();
		 //System.out.println(c.length);
		 //System.out.println(c1.length);
		 
		/*
		 * for(int i=0;i<c.length;i++) { System.out.println(c[i]); }
		 * 
		 * for(int i=0;i<c1.length;i++) { System.out.println(c1[i]); }
		 */ 
		 boolean blnResult = Arrays.equals(c,c1);
		 System.out.println("Are two char arrays equal ? : " + blnResult);
		 if(blnResult)
		 {
			 return true;
		 }
		 
		 else
		 {
			 return false;
		 }
		 
	  }
	 
	 
	 public static String screenshot(WebDriver driver)
	 {
		
		 File file1 = null;
		 String path="";
		 try
			{  
				file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				path = System.getProperty("user.dir")+"\\screenshots\\snap.png";
				file1 = new File(path);
				FileUtils.copyFile(file, file1);
				
				
				
				
			}
		
		catch(Exception e)
			{
			   e.getStackTrace();
			}
		
		 return path;
		 
	 }
	 
	 public void actionMoveToElement(WebDriver driver, WebElement element)
	 {
		ac = new Actions(driver);
		ac.moveToElement(element).click().build().perform();
		
	 }
	 
	 public void getKeysFromProperties()
	 {
		 Set<Object> set = Base.prop.keySet();
		 System.out.println(set);
	     for(Object ob : set)
	     {
	    	 String s = ob.toString();
	    	 System.out.println(s);
	     }
	 }
	 
	 
	 
	

}