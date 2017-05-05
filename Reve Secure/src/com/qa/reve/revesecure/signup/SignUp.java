package com.qa.reve.revesecure.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp
{
WebDriver driver;

public SignUp(WebDriver driver)
{
	this.driver = driver;
  }
	

public void enterName()
{
driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("Ankur");
 }
	
public void enterOrganization()
{
driver.findElement(By.xpath(".//*[@id='OrgName']")).sendKeys("Revesoft");	
 }

public void clickDropdown()
{
	driver.findElement(By.xpath(".//*[@id='loginForm']/div[2]/div[2]/div/div/div")).click();
	driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/div/div/ul/li[101]")).click();
	driver.findElement(By.xpath(".//*[@id='demo']")).sendKeys("971277780");
}

public void enterEmailid()
{
	driver.findElement(By.xpath(".//*[@id='PrimaryEmailId']")).sendKeys("agarwal.ankur@revesoft.com");

 }

public void enterPassword()
{
	driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("Ankur892");
 }

public void reenterPassword()
{
	driver.findElement(By.xpath(".//*[@id='repass']")).sendKeys("Ankur892");
 }

public void enterSignUpbutton()
{
	driver.findElement(By.xpath(".//*[@id='loginForm']/div[3]/div[2]/input")).click();	
 }

public void base()
{
	enterName();
	enterOrganization();
	clickDropdown();
	enterEmailid();
	enterPassword();
	reenterPassword();
	enterSignUpbutton();
	
	 	
}


}
