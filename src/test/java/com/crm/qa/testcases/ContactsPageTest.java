package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homePage; 
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginpage= new LoginPage ();
		contactsPage= new ContactsPage();
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContacts();
	}
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing on the page");
	}
	@Test(priority=2)
	public void SelectContactsTest() {
		contactsPage.SelectContacts();
	}
	@DataProvider
	public Object [][] getCRMTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		//homePage.createNewContact("Shahina", "Akter", "Google");
		homePage.createNewContact(firstName, lastName, company);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
