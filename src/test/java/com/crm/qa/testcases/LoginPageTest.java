package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	public LoginPageTest(){
		super();// it will initialize the super class constructor 
	}
	
	@BeforeMethod
	public void setup() {
		initialization();//just calling the this method from TaseBase class
		loginPage = new LoginPage();		
	}
	@Test (priority=1)
	public void liginPageTest() {
		String title = loginPage.validateLoginPaeTitle();
		Assert.assertEquals(title, "Free CRM in the cloud software boosts sales");
	}
	@Test (priority=2)
	public void crmLogoTest() {
		boolean flag =loginPage.validateCRMImage();
		Assert.assertTrue(flag);		
	}
	@Test(priority=3)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
