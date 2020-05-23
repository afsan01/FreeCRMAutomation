package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage; 
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
		
		//test case should be separeted--independent with each other
		//before each test case--launch the browser and login
		//@test-- execute test case
		//after each test case--close the browser
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginpage= new LoginPage ();
		contactsPage= new ContactsPage();
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","HOME PAGE TITLE IS NOT CORRECT");
	
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
		//testUtil.switchToFame();
		Assert.assertTrue(homePage.VerifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage=homePage.clickOnContacts();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
