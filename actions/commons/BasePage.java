package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

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
		expliciWait = new WebDriverWait(driver, timeout);
		return expliciWait.until(ExpectedConditions.alertIsPresent());
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

	private Alert alert;
	private WebDriverWait expliciWait;
	private long timeout = 30;
}
