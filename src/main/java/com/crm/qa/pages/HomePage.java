package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Mahbubur Rahman')]")
	@CacheLookup  //If you need the webelement reeequently you can use this annotation to store the 
				  //webelement and use without call the url every times. 
	WebElement userNameLabel;
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendar;
	@FindBy (xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	@FindBy (xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	@FindBy (xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	@FindBy(xpath="//*[contains(text(),'New')]")
	WebElement newContacts;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="company")
	WebElement company;
	@FindBy(xpath="//*[contains(text(),'Save')]")
	WebElement savebtn;
	
	//Initializing the Pager objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean VerifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContacts(){
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPages clickOnDealsLink(){
		dealsLink.click();
		return new DealsPages();
	}
	public TasksPages clickOntasksLink(){
		tasksLink.click();
		return new TasksPages();
	}
	public void clickOnNewContactLink() {
		newContacts.click();
	}
	public void createNewContact(String fName,String lName,String copm) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(copm);
		savebtn.click();
	}

}
