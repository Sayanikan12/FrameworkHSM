package hms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {

	WebDriver driver;

	public DoctorLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement userNameDr;

	@FindBy(name = "password")
	private WebElement passwordDr;

	@FindBy(name = "submit")
	private WebElement loginBtn;

	public WebElement getUserNameDr() {
		return userNameDr;
	}

	public WebElement getPasswordDr() {
		return passwordDr;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void logintoDoctor(String url, String usernameAd, String passwordAd) throws InterruptedException {
		HomePage hp = new HomePage(driver);
		driver.get(url);
		hp.doctorClick();
		Thread.sleep(3000);
		userNameDr.sendKeys(usernameAd);
		passwordDr.sendKeys(passwordAd);
		loginBtn.click();
	}
	
	public void logintoDoctor(String usernameAd, String passwordAd) throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.doctorClick();
		Thread.sleep(3000);
		userNameDr.sendKeys(usernameAd);
		passwordDr.sendKeys(passwordAd);
		loginBtn.click();
	}

}
