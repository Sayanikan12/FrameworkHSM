package hms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.generic.fileutlity.WebDriverUtility;

public class UserLoginPage {
	WebDriver driver;
	public UserLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userNameUs;
	
	@FindBy(name="password")
	private WebElement passwordUs;
	
	
	@FindBy(name="submit")
	private WebElement loginBtn;
	
	public WebElement getUserNameAd() {
		return userNameUs;
	}


	public WebElement getPasswordAD() {
		return passwordUs;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	
	public void logintoUser(String url,String usernameAd, String passwordAd) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		//WebDriverUtility wb=new WebDriverUtility();
		driver.get(url);
		//wb.toMaximizeWindow(driver);
		hp.userClick();
		Thread.sleep(3000);
		userNameUs.sendKeys(usernameAd);
		passwordUs.sendKeys(passwordAd);
		loginBtn.click();
		Thread.sleep(3000);
		
	}
	
	
	
	
	
}
