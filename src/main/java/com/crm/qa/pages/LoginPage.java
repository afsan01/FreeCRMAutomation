package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object repository
	@FindBy(xpath="//span[contains(text(), 'Log In')]")
	WebElement Login;
	@FindBy(name="email")
	WebElement email;
	@FindBy (name="password")
	WebElement pass;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
    WebElement submit;
	@FindBy(xpath ="//a[contains(text(), 'Sign Up')]")
	WebElement signup;
    @FindBy(xpath="(//a[contains(@class, 'brand-name')])[1]")
    WebElement crmLogo;

    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle() {
    	return driver.getTitle();
    }
    public boolean validateCRMImage() {
    	return crmLogo.isDisplayed();
    }
    public HomePage login (String un, String pwd) {
    	Login.click();
    	email.sendKeys(un);
    	pass.sendKeys(pwd);
    	submit.click();
    	
    	return new HomePage();
    	
    }
    
    
    
    
    
}