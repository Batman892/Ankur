package com.qa.reve.revesecure.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard 
{
WebDriver driver;

public Dashboard(WebDriver driver)
{
this.driver = driver;	
}


public void clickDashboard()
{
 driver.findElement(By.xpath("//a[contains (text(),'Dashboard')]")).click();
 }

public void windowHandle()
{
	for(String winHandle : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle);
	}

 }

public void clickSignUp()
{
	driver.findElement(By.xpath(".//*[@id='chkBut']")).click();
	
}

public void base()
{
	clickDashboard();
	windowHandle();
	clickSignUp();
}




}
