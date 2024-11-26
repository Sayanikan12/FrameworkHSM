package hms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.generic.fileutlity.WebDriverUtility;

public class AdminLoginPage {
	WebDriver driver;
	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameAd;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordAD;
	
	
	@FindBy(name="submit")
	private WebElement loginBtn;
	
	public WebElement getUserNameAd() {
		return userNameAd;
	}


	public WebElement getPasswordAD() {
		return passwordAD;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	
	public void logintoAdmin(String url,String usernameAd, String passwordAd) throws InterruptedException {
		//WebDriverUtility wb=new WebDriverUtility();
		HomePage hp=new HomePage(driver);
		driver.get(url);
		//wb.toMaximizeWindow(driver);
		hp.adminClick();
		Thread.sleep(3000);
		userNameAd.sendKeys(usernameAd);
		passwordAD.sendKeys(passwordAd);
		loginBtn.click();
		Thread.sleep(3000);
	}
	
	
	
	
	
}
