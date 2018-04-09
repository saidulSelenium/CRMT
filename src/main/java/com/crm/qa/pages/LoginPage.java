package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {
	
	//Page Factory -OR- Page Object
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(), 'Sign Up' )]")//text came here as a function 
	WebElement signUpBtn;
	
	@FindBy (xpath="//img[contains(@class, 'img-responsiv' )]")
	WebElement crmLogo;
	
	
	// Initializing the page object .now need to initialize the above page factory element with WebDriver under the this class's constructor.
	
	public LoginPage () {
		PageFactory.initElements(driver, this);// here THIS mean current class object
		
	}
	
	//Action
	public String validateLoginPaeTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	public void login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}

}


