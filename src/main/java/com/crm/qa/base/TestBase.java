package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver; 
	public static Properties prop;
	
	
	public TestBase(){
		
	prop = new Properties();// Properties class used to load the file  and below FileInputStream is used to connect with file.
	
	try {
		FileInputStream ip= new FileInputStream("C://Users//haque//Desktop//selenium files"
				+"//Eclipse Files//FreeCRMTest//src//main//java//com//crm//qa//config//config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
     public static void initialization() {
    	 
    	 String browserName = prop.getProperty("browser");
    	 
    	 if(browserName.equals("chrome")) {
    		 System.setProperty("webdriver.chrome.driver", "C://Users//haque//Desktop//selenium files//Driver//ChromeDriverNew//chromedriver.exe");
    	     driver = new ChromeDriver();
    	 } else if(browserName.equals("Firefox")) {
    		 System.setProperty("webdriver.gecko.driver","C://Users//haque//Desktop//selenium files//Driver//GeckoDriver//geckodriver.exe");
    		 driver = new FirefoxDriver();
    	 } 
    	 driver.manage().window().maximize();
    	 driver.manage().deleteAllCookies();
    	 driver.get(prop.getProperty("url"));
    	 try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    	 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
     }
	
	
	
	
	
}
