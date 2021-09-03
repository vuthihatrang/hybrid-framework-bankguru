package baseObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.OrderPageUI;

public class OrderPageObject extends BasePage {
	
	WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public MyAccountPageObject openMyAccountPage() {
		waitForElementClickable(driver, OrderPageUI.MY_ACCOUNT_FOOTER);
		clickToElement(driver, OrderPageUI.MY_ACCOUNT_FOOTER);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
		

}
