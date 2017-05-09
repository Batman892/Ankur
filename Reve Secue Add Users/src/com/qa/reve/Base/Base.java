package com.qa.reve.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.reve.AddToken.AddToken;
import com.qa.reve.Addservices.AddServices;
import com.qa.reve.Login.Login;
import com.qa.reve.addusers.AddUser;

import jxl.read.biff.BiffException;

public class Base
{
	public static WebDriver driver;
	static Properties prop = new Properties(); 
	static String Url;
	
	@BeforeSuite
	public void launchUrl() throws FileNotFoundException, IOException, BiffException, InterruptedException
	{   
		 prop.load(new FileInputStream("Browser.txt")); 
	     browserlaunch();
		 driver.get(prop.getProperty("Url"));
		/*ChromeOptions options = new ChromeOptions();  
		options.addArguments("chrome.switches","--disable-extensions");          
		new DesiredCapabilities();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(caps);*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
		public void browserlaunch()
		 {   
	         if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) 
				{
					System.setProperty("webdriver.chrome.driver", "D://Chrome driver//chromedriver.exe");
					driver = new ChromeDriver();

				} 
	         else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) 
				{
					driver = new FirefoxDriver();
				} 
	         
	         else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) 
				{
				 System.setProperty("webdriver.edge.driver", "D://Edgedriver//MicrosoftWebDriver.exe");
	        	 driver = new EdgeDriver();
				} 
	         else if (prop.getProperty("Browser").equalsIgnoreCase("ie")) 
	         {
	        	 System.setProperty("webdriver.ie.driver","D://Internet explorer driver//IEDriverServer.exe" );
	        	 //driver = new InternetExplorerDriver();
	        	 DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
	             ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	             driver = new InternetExplorerDriver(ieCapabilities);
				} 
		 }
	
		
		@Test(priority = 0,enabled = true)
		public void verifyLogin() throws BiffException, InterruptedException, IOException
		{
		Login objLogin = new Login(driver);
		objLogin.base();
		}
		
		@Test (priority = 1)
		public void verifyAddUser() throws BiffException, InterruptedException, IOException
		{
		AddUser objAddUser = new AddUser (driver);
		objAddUser.base();
		}
		
		@Test (priority = 3)
		public void verifyAddServices() throws BiffException, InterruptedException, IOException
		{
		AddServices objAddServices = new AddServices(driver);
		objAddServices.base();
		}
		
		@Test (priority = 2)
		public void verifyAddToken() throws BiffException, InterruptedException, IOException
		{
		AddToken objAddToken = new AddToken(driver);
		objAddToken.base();
		}
		
}
		
