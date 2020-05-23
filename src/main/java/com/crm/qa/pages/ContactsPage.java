package com.crm.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactLabel;
	@FindBy(xpath="//input[@name='id'])[1]")
	WebElement checkbox;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactLabel.isDisplayed();
	}
	public void SelectContacts() {
		checkbox.click();
	}
	

}
