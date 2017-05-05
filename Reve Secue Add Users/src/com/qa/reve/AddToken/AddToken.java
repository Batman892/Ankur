package com.qa.reve.AddToken;

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

public class AddToken 
{
  WebDriver driver;
  String Token;
  String Serial;
  
  By Tokens = By.xpath(".//*[@id='tokens']/a");
  By AddTokens = By.xpath(".//*[@id='contentWindow']/div/div/div[2]/button");
  By Service = By.xpath(".//*[@id='con']/select[1]");
  By token = By.xpath(".//*[@id='tname']");
  By serial= By.xpath(".//*[@id='con']/input[4]");
		  
  public AddToken (WebDriver driver)
   {
	  this.driver = driver;
	 }

public void clickTokens() throws InterruptedException
  {
	  WebElement element = driver.findElement(Tokens);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", element);
	  executor.executeScript("alert('Tokens clicked');");
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
   }
/*
public void clickAddTokens() throws InterruptedException
{
	  WebElement element = driver.findElement(AddTokens);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", element);
	  executor.executeScript("alert('AddTokens clicked');");
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
  }
public void enterHardwareType() throws InterruptedException
{   
	 Select sel = new Select(driver.findElement(Service));
	  sel.selectByIndex(1);
	  Thread.sleep(5000);
	  System.out.println("print");
 }*/

public void enterTokenName() throws BiffException, IOException
{
    FileInputStream fis = new FileInputStream("email.xls");
    Workbook wb = Workbook.getWorkbook(fis);
    Sheet sh= wb.getSheet(1);
    int rows=sh.getRows();
    System.out.println("No of rows:" + rows);
    
 try
 {
    for(int i=1; i<rows; i++)
    {
      WebElement element = driver.findElement(AddTokens);
  	  JavascriptExecutor executor = (JavascriptExecutor)driver;
  	  executor.executeScript("arguments[0].click();", element);
  	  executor.executeScript("alert('AddTokens clicked');");
  	  Thread.sleep(2000);
  	  driver.switchTo().alert().accept();
  	  
  	  Select sel = new Select(driver.findElement(Service));
	  sel.selectByIndex(1);
	  Thread.sleep(5000);
	  System.out.println("option clicked");
  	  
        Token=sh.getCell(0,i).getContents();
        Serial=sh.getCell(1,i).getContents();
        
        Thread.sleep(5000);
        WebElement element1 = driver.findElement(token);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element1)).sendKeys(Token);
       
        WebElement element2 = driver.findElement(serial);
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.elementToBeClickable(element2)).sendKeys(Serial);
        driver.findElement(By.xpath(".//*[@id='con']/button[2]")).click();
        Thread.sleep(5000);
        
   }   
 }
   catch(Exception e)
    {
     e.printStackTrace();
    }
 }
public void base() throws InterruptedException, BiffException, IOException
  {
	  clickTokens(); 
	 // clickAddTokens();
	  //enterHardwareType();
	  enterTokenName();
  }
}
