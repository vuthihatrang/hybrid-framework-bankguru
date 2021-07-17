package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.jmx.ManagedAttribute;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_And_Login_Repeat {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String userName, password, loginPageURL;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "/browserDrives/geckodriver");
		;
		driver = new FirefoxDriver();
		loginPageURL = "http://demo.guru99.com/v4/index.php";
		driver.get(loginPageURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys(randomEmail());
		driver.findElement(By.name("btnLogin")).click();
		userName = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}

	@Test
	public void Login_02_Register_To_System() {
		driver.get(loginPageURL);
		driver.findElement(By.name("uid")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();

		String welcomeMessage = driver.findElement(By.cssSelector("marquee.heading3")).getText();
		Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99 Bank");

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
