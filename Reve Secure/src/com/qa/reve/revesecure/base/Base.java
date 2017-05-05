package com.qa.reve.revesecure.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.reve.revesecure.dashboard.Dashboard;
import com.qa.reve.revesecure.signup.SignUp;

public class Base 
{
  static WebDriver driver;
  
  
  
  public static void main (String args[])
  {
	 WebDriver driver = new FirefoxDriver();
	 driver.get("https://www.revesecure.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 
	 Dashboard objDashboard = new Dashboard(driver);
	 objDashboard.base();
	 
	 SignUp objSignUp = new SignUp(driver);
	 objSignUp.base();	  
	  
  }
  
}
