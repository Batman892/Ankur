package com.qa.reve.revesecure.linkcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LinkCheck 
{
WebDriver driver;

String email = "agarwal.ankur@revesoft.com";
String password = "Ankur892";

By Email = By.xpath(".//*[@id='loginID']");
By Login = By.xpath("html/body/div[1]/div[5]/form/div/input[5]");


public LinkCheck (WebDriver driver)
{
	this.driver = driver;
 }

public void enterEmail() throws InterruptedException
{
driver.findElement(Email).sendKeys(email);	
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("alert('Email id Entered');");
Thread.sleep(2000);
driver.switchTo().alert().accept();
}

public void enterPassword() throws InterruptedException
{Thread.sleep(2000);
driver.findElement(By.name("password")).sendKeys(password);
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("alert('Password Entered');");
Thread.sleep(2000);
driver.switchTo().alert().accept();
 }

public void clickSignInbutton() throws InterruptedException
{//Thread.sleep(2000);
driver.findElement(Login).click();
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("alert('sign up button clicked');");
Thread.sleep(2000);
driver.switchTo().alert().accept();
  }

//////Base Method///////////
public void base() throws InterruptedException
{
	enterEmail();
	enterPassword();
	clickSignInbutton();

   }	

}
