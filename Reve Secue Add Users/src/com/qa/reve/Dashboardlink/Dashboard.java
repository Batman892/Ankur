package com.qa.reve.Dashboardlink;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard 
{
   WebDriver driver	;
	
   
   By Dashboard = By.xpath(".//*[@id='dashboard']/a");
   By Table = By.xpath(".//*[@id='tableV']");
   
	public Dashboard(WebDriver driver)
	{
		this.driver = driver;
	}
	
public void clickDashboardlink() throws InterruptedException
  {
	 int size = driver.findElements(By.xpath(".//*[@id='contentWindow']/div[1]/div/div/label")).size();
	 System.out.println(size); 
	  
	 for (int i=1;i<=size;i++)
	 {  
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='contentWindow']/div[1]/div/div["+i+"]/label"))).click();
		 Thread.sleep(5000);
		  WebElement element = driver.findElement(Dashboard);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);
		  executor.executeScript("alert('Dashboard clicked');");
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();
		  Thread.sleep(5000);
	 }
  }
public void clickRecentactivity() throws InterruptedException
   {
	  WebElement element = driver.findElement(Table);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", element);
	  executor.executeScript("alert('buttton clicked');");
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	}

public void base() throws InterruptedException
{
	clickDashboardlink();
	clickRecentactivity();

 }

}

