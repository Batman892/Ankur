package com.qa.reve.Addservices;

import java.io.FileInputStream;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AddServices 
{
WebDriver driver;

String service;

By Services = By.xpath(".//*[@id='services']/a");
By AddServices = By.xpath(".//*[@id='contentWindow']/div/div/div[2]/button");
By ServiceName = By.xpath(".//*[@id='con']/input[3]");
By ServiceType = By.xpath(".//*[@id='con']/select[1]");
By ServiceVersion = By.xpath(".//*[@id='con']/select[2]");
By Submit = By.xpath(".//*[@id='con']/button[2]");

public AddServices (WebDriver driver)
{
  this.driver = driver;	
 }

public void clickServices() throws InterruptedException
{
	  WebElement element = driver.findElement(Services);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", element);
	  executor.executeScript("alert('Services clicked');");
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
  }

public void enternewService() throws BiffException, IOException
{    
	   FileInputStream fis = new FileInputStream("email.xls");
	    Workbook wb = Workbook.getWorkbook(fis);
	    Sheet sh= wb.getSheet(3);
	    int rows=sh.getRows();
	    System.out.println("No of rows:" + rows);
	    
	 try
	 {
	    for(int i=1; i<rows; i++)
	      {
	    	  WebElement element = driver.findElement(AddServices);
	    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	  executor.executeScript("arguments[0].click();", element);
	    	  executor.executeScript("alert('AddServices clicked');");
	    	  Thread.sleep(2000);
	    	  driver.switchTo().alert().accept();
	    	  Thread.sleep(5000);
	    	
	    	  service =sh.getCell(0,i).getContents();
	    	  WebElement element1 = driver.findElement(ServiceName);
	          WebDriverWait wait = new WebDriverWait(driver, 10);
	          wait.until(ExpectedConditions.elementToBeClickable(element1)).sendKeys(service);
	          
	          Select sel = new Select(driver.findElement(ServiceType));
	    	  sel.selectByIndex(1);
	    	  Thread.sleep(3000);
	    	  System.out.println("option clicked");
	    	  
	    	  Select sel1 = new Select(driver.findElement(ServiceVersion));
	    	  sel1.selectByIndex(0);
	    	  Thread.sleep(3000);
	    	  System.out.println("option clicked");
	    	  Thread.sleep(5000);
	    	  
	    	  WebElement element2 = driver.findElement(Submit);
	    	  JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	    	  executor2.executeScript("arguments[0].click();", element2);
	    	  Thread.sleep(5000);
	    	  
	     }   
	 }
	    
	 catch(Exception e)
	    {
	     e.printStackTrace();
	    }

 }

public void base () throws InterruptedException, BiffException, IOException
{
	clickServices();
	enternewService();
  }

}
