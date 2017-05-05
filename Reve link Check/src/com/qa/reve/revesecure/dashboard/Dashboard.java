package com.qa.reve.revesecure.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard 
{
WebDriver driver;

By Dashboard = By.xpath(".//*[@id='dashboard']/a");
By User = By.xpath(".//*[@id='users']/a");
By Services = By.xpath(".//*[@id='services']/a");
By Tokens = By.xpath(".//*[@id='tokens']/a");
By ByPasscode = By.xpath(".//*[@id='bypasscode']/a");
By Policy = By.xpath(".//*[@id='policy']/a");
By Billing = By.xpath(".//*[@id='billing']/a");
By Login = By.xpath(".//*[@id='divTopMenu']/ul/li/a");



public Dashboard (WebDriver driver)
{
  this.driver = driver;
 }

public void clickDashboard() throws InterruptedException
{
  WebElement element = driver.findElement(Dashboard);
  JavascriptExecutor executor = (JavascriptExecutor)driver;
  executor.executeScript("arguments[0].click();", element);
  executor.executeScript("alert('Dashboard clicked');");
  Thread.sleep(2000);
  driver.switchTo().alert().accept();
 }

public void clickUser() throws InterruptedException
{   
	WebElement element = driver.findElement(User);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	executor.executeScript("alert('User clicked');");
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
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

public void clickTokens() throws InterruptedException
{
  WebElement element = driver.findElement(Tokens);
  JavascriptExecutor executor = (JavascriptExecutor)driver;
  executor.executeScript("arguments[0].click();", element);
  executor.executeScript("alert('Tokens clicked');");
  Thread.sleep(2000);
  driver.switchTo().alert().accept();
 }

public void clickByPassCodes() throws InterruptedException
{
  WebElement element = driver.findElement(ByPasscode);
  JavascriptExecutor executor = (JavascriptExecutor)driver;
  executor.executeScript("arguments[0].click();", element);
  executor.executeScript("alert('ByPassCodes clicked');");
  Thread.sleep(2000);
  driver.switchTo().alert().accept();
 }

public void clickPolicy() throws InterruptedException
{
  WebElement element = driver.findElement(Policy);
  JavascriptExecutor executor = (JavascriptExecutor)driver;
  executor.executeScript("arguments[0].click();", element);
  executor.executeScript("alert('Policy clicked');");
  Thread.sleep(2000);
  driver.switchTo().alert().accept();
 }

public void clickBilling() throws InterruptedException
{
  WebElement element = driver.findElement(Billing);
  JavascriptExecutor executor = (JavascriptExecutor)driver;
  executor.executeScript("arguments[0].click();", element);
  executor.executeScript("alert('Billing clicked');");
  Thread.sleep(2000);
  driver.switchTo().alert().accept();
 }

public void clickLogINbutton() throws InterruptedException
{
  driver.findElement(Login).click();
  JavascriptExecutor executor = (JavascriptExecutor)driver;
  executor.executeScript("alert('LogINbutton clicked');");
  driver.switchTo().alert().accept();
  
 int size = driver.findElements(By.xpath(".//*[@id='divTopMenu']/ul/li/ul/li/a")).size();
 System.out.println(size); 
  
 for (int i=1;i<=size;i++)
 {  
	 WebDriverWait wait = new WebDriverWait(driver, 20);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='divTopMenu']/ul/li/ul/li["+i+"]/a"))).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(".//*[@id='divTopMenu']/ul/li/a")).click();
	 Thread.sleep(5000);
	 
 }
}
//////Base Method/////////
public void base() throws InterruptedException
{
  clickDashboard();
  clickUser();
  clickServices();
  clickTokens();
  clickByPassCodes();
  clickPolicy();
  clickBilling();
  clickLogINbutton();
  
}



}
