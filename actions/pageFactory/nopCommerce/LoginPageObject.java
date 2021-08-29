package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {

	private WebDriver driver;
	
	@FindBy (css="input[@id='Email']")
	WebElement emailTextBox;
	
	@FindBy (xpath="//input[@id='Password']")
	WebElement passwordTextBox;
	
	@FindBy (xpath = "//button[text() ='Log in']")
	WebElement loginButton;
	
	public LoginPageObject( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterToEmailTextbox( String email) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, email);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver,passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

}
