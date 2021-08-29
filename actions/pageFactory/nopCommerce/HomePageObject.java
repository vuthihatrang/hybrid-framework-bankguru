package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;


public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	//page factory
	
	//UI
	//@FindBy (how = How.ID, using ="nivo-slider")
	@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className="ico-register")
	WebElement registerLink ;
	
	@FindBy(className ="ico-login")
	WebElement loginLink;
	

	public HomePageObject( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// init các Element => việc khởi init các element chưa find element
		//tạo ra 1 kết nối giữa find by và element => luwu vào trong cache
		// khi nào gọi hàm cần eleemnt sẽ đi tìm 
	}
	//actions
	public boolean isHomePageSilderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
