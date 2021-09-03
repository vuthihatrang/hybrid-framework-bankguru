package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.nopCommerce.HomePageObject;
import baseObject.nopCommerce.LoginPageObject;
import baseObject.nopCommerce.MyAccountPageObject;
import baseObject.nopCommerce.OrderPageObject;
import baseObject.nopCommerce.PageGeneratorManager;
import baseObject.nopCommerce.RegisterPageObject;
import baseObject.nopCommerce.SearchPageObject;
import commons.BaseTest;

public class Level_07_Register_And_Login_Switch_Page_Object extends BaseTest {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String emailAddress, password;

	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {

		driver = getBrowerDriver(browserName,appUrl);
		
		emailAddress = randomEmail();
		System.out.println("Email= " + emailAddress);
		password="123456"; 
	}

	@Test
	public void Login_01_Register_To_System() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSilderDisplayed());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickTogGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("sachiko");
		registerPage.enterToLastnameTextbox("tran");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isHomePageSilderDisplayed());

	}

	@Test
	public void Login_02_Register_To_System() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSilderDisplayed());

	}
	
	@Test
	// chứng năng chứ hk phải là test case 
	public void Login_03_Switch_Page_At_Footer() {
		//home page -> search page 
		searchPage = homePage.openSearchPage(driver);
		//search page -> my account page
		myAccountPage = searchPage.openMyAccountPage(driver);
		//my account page->order page
		orderPage= myAccountPage.openOrderPage(driver);
		//order page -> my account page
		myAccountPage = orderPage.openMyAccountPage(driver);
		//my account - search page 
		searchPage = myAccountPage.openSearchPage(driver);
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();

	}

	public String randomEmail() {
		Random rand = new Random();

		return "sachiko" + rand.nextInt(99999) + "@vmail.com";
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}
