package com.qa.reve.revesecure.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.reve.revesecure.dashboard.Dashboard;
import com.qa.reve.revesecure.linkcheck.LinkCheck;

public class Base 
{
	 public static WebDriver driver;
	 static Properties prop = new Properties(); 
	 static String Url;
	 
	 public static void browserlaunch()
	 {   
          if (prop.getProperty("browser").equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", "D://Chrome driver//chromedriver.exe");
				driver = new ChromeDriver();

			} 
          else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) 
			{
				
				driver = new FirefoxDriver();
			} 
          else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
          {
        	  System.setProperty("webdriver.edge.driver", "./utility/MicrosoftWebDriver.exe");
        	  driver = new  EdgeDriver();
			}

		}	
	 
public static void main (String args[]) throws InterruptedException, FileNotFoundException, IOException
	  {
	     prop.load(new FileInputStream("./utility/Browser.txt")); 
	     browserlaunch();
		
	     driver.get(prop.getProperty("Url"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 
	 
		 LinkCheck objLinkCheck = new LinkCheck (driver);
		 objLinkCheck.base();
		 
		 Dashboard objDashboard = new Dashboard(driver);
		 objDashboard.base();
		 
		 
  }
}
