package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectLocation= System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	private enum BROWSER{
		CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY,EDGE_CHROMIUM, H_CHROME, H_FRIREFOX;
	}
	private enum PLATFORM{
		ANDROID, IOS;
	}
	private enum OS{
		WINDOWS, MAC_OSX;
	}
	
	
	protected WebDriver getBrowerDriver(String browserName ) {
		
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		if(browser == BROWSER.FIREFOX) {
			setBrowserDriverProperty();
			driver = new FirefoxDriver();
		}else if(browser == BROWSER.CHROME) {
			setBrowserDriverProperty();
			driver = new ChromeDriver();
		}else {
			throw new RuntimeException("Please enter browser name");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
		
	}
	
	protected WebDriver getBrowerDriver(String browserName, String appURL ) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if(browser == BROWSER.FIREFOX) {
			setBrowserDriverProperty();
			driver = new FirefoxDriver();
		}else if(browser == BROWSER.CHROME) {
			setBrowserDriverProperty();
			driver = new ChromeDriver();
		}else {
			throw new RuntimeException("Please enter browser name");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
		
	}
	protected void setBrowserDriverProperty() {
		String browserFolderPath = projectLocation + getSlash("browserDrives");
		if (isWindows()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver");
		
		}else {
			throw new RuntimeException("OS not support");
		}
	}

	private String getSlash(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}
	public String randomEmail() {
		Random rand = new Random();

		return "sachiko" + rand.nextInt(99999) + "@vmail.com";
	}
}
