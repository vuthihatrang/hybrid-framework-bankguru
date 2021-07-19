package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_03_Register_And_Login_BasePage_2 {
	WebDriver driver;
	BasePage basePage;
	String projectLocation = System.getProperty("user.dir");
	String userName, password, loginPageURL;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "/browserDrives/geckodriver");
		driver = new FirefoxDriver();
		loginPageURL = "http://demo.guru99.com/v4/index.php";
		driver.get(loginPageURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//che giau su khoi tao doi tuong
		basePage = BasePage.getBasePage();
	}
	@Test
	public void Login_01_Register_To_System() {

		basePage.clickToElement(driver, "//a[text()='here']");

		basePage.sendkeyToElement(driver, "//input[@name='emailid']", randomEmail());

		basePage.clickToElement(driver, "//input[@name='btnLogin']");

		userName = basePage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = basePage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void Login_02_Register_To_System() {
		
		basePage.openPageUrl(driver, loginPageURL);
		
		basePage.sendkeyToElement(driver, "//input[@name='uid']", userName);
		
		basePage.sendkeyToElement(driver, "//input[@name='password']", password);
	
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");

	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();

	}

	public String randomEmail() {
		Random rand = new Random();

		return "sachiko" + rand.nextInt(99999) + "@vmail.com";
	}
}
