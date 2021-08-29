package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseObject.nopCommerce.HomePageObject;
import baseObject.nopCommerce.LoginPageObject;
import baseObject.nopCommerce.RegisterPageObject;
import commons.BaseTest;

public class Level_04_Register_And_Login_Muntiple_Browser extends BaseTest {
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
		// Step1 : Open URL-> home page
		homePage = new HomePageObject(driver);

		// verify Home page is displayed
		Assert.assertTrue(homePage.isHomePageSilderDisplayed());

		// Step 2: Click to register link -> register page
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		// step 3: Click to Gender mail radio
		registerPage.clickTogGenderMaleRadioButton();

		// step 4: Input First name
		registerPage.enterToFirstnameTextbox("sachiko");

		// step 5: Input last name
		registerPage.enterToLastnameTextbox("tran");

		// step 6: Input email
		registerPage.enterToEmailTextbox(emailAddress);

		// step 7: Input password
		registerPage.enterToPasswordTextbox(password);

		// step 8: Input to confirm password
		registerPage.enterToConfirmPasswordTextbox(password);

		// Step 9: Click to register button
		registerPage.clickToRegisterButton();

		// step 10 Verify success message displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		// Step 11: Click to Logout
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);

		// verify Home page is displayed
		Assert.assertTrue(homePage.isHomePageSilderDisplayed());

	}

	@Test
	public void Login_02_Register_To_System() {
		// Step 1 : Click to lohin lInk
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		// Step 2: Input to Email Text box
		loginPage.enterToEmailTextbox(emailAddress);

		// Step 3:input to password text box
		loginPage.enterToPasswordTextbox(password);

		// Step 4: Click to login button
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

		// verify Home page is displayed
		Assert.assertTrue(homePage.isHomePageSilderDisplayed());

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

}
