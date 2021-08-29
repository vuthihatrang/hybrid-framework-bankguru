package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {

	private WebDriver driver;
	
	@FindBy (id = "gender-male")
	WebElement genderMaleRadio ;
	
	@FindBy (xpath = "//input[@id ='FirstName']")
	WebElement firstNameTextBox;
	
	@FindBy (xpath = "//input[@id ='LastName']")
	WebElement lastNameTextBox;
	
	@FindBy (xpath = "//input[@id ='Email']")
	WebElement emailTextBox;
	
	@FindBy (xpath = "//input[@id ='Password']")
	WebElement passwordTextBox;
	
	@FindBy (xpath = "//input[@id ='ConfirmPassword']")
	WebElement confirmPasswordTextBox;
	
	@FindBy (xpath = "//button[@id ='register-button']")
	WebElement registerButton;
	
	@FindBy (xpath = "//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;
	
	@FindBy (xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	
	
	public RegisterPageObject ( WebDriver driver) {
		this.driver = driver;
	}
	public void clickTogGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
		
	}

	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);
		
	}

	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, lastName);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void enterToConfirmPasswordTextbox(String confimPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, confimPassword);
	}
		

	public void clickToRegisterButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
		
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, firstNameTextBox);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
