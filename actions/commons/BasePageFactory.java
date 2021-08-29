package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		// alert = driver.switchTo().alert();
		alert = waitForAlertPresence(driver);
		alert.accept();

	}

	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();

	}

	public void senkeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);

	}

	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();

	}

	public void switchToWindownTabByID(WebDriver driver, String windownID) {
		// get all id of window/tab current
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			if (!id.equals(windownID)) {
				// switch into this ID
				driver.switchTo().window(id);
				sleepInSecond(2);
				break;
			}

		}
	}

	public void swithToWindownTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedWindowTitle)) {
				break;
			}

		}
	}

	public void closeWindowWithoutParent(WebDriver driver, String windownID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			driver.switchTo().window(id);
			if (!id.equals(windownID)) {
				driver.close();
				sleepInSecond(2);
			}

		}
	}

	public void sleepInSecond(long time) {

		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
		
	}
	public void sendkeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		
	}
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
		
	}
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private Alert alert;
	private long timeout = 30;
	private WebDriverWait explicitWait;
}
