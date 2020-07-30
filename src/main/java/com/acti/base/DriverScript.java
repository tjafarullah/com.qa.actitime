package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * Name: Tahani
 * Date: 7/30/2020
 * Date Modified:
 * Approved: *****
 */


public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public DriverScript() throws Exception 
	{
		try
		{
			File file = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to load the Properties file"+e.getMessage());
		}
	}
	
	
	public static void initBrowser()
	{
	  String bro = prop.getProperty("browser");	
	  if(bro.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		  driver=new ChromeDriver();
		  
	  }
	  else if(bro.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
		  driver=new FirefoxDriver();
		    
	  }
	  else if(bro.equalsIgnoreCase("ie"))
	  {
		  System.setProperty("webdriver.gecko.driver", "./Browsers/IEDriverServer.exe");
		  driver=new InternetExplorerDriver(); 
	  }
	  
	  else
	  {
		System.out.println("No Browser specified properly ");  
	  }
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  
	  String url = prop.getProperty("qaurl");
	  driver.get(url);
	}

}
