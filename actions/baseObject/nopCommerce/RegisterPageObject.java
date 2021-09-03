package baseObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;
	
	public RegisterPageObject ( WebDriver driver) {
		this.driver = driver;
	}
	public void clickTogGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver,RegisterPageUI.FIRSTNAME_TEXTBOX );
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisible(driver,RegisterPageUI.LASTNAME_TEXTBOX );
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX );
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX );
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confimPassword) {
		waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX );
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confimPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.RESITER_BUTTON);
		clickToElement(driver, RegisterPageUI.RESITER_BUTTON);
		
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}
