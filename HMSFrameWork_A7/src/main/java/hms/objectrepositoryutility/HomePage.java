package hms.objectrepositoryutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='text list_1_of_2']/h3[text()='Admin Login']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement adminLink;
	
	@FindBy(xpath="//div[@class='text list_1_of_2']/h3[text()='Doctors Login']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement doctorLink;
	
	@FindBy(xpath="//div[@class='text list_1_of_2']/h3[text()='Patients']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement userLink;
	
	@FindBy(linkText="contact")
	private WebElement contactLink;
	
	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getDoctorLink() {
		return doctorLink;
	}

	public WebElement getUserLink() {
		return userLink;
	}
	
	
	
	public void adminClick() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(adminLink).perform();
		adminLink.click();
		
	}
	
	public void doctorClick() {
		Actions action=new Actions(driver);
		action.moveToElement(doctorLink).perform();
		doctorLink.click();
	
	}
	
	public void userClick() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions action=new Actions(driver);
		action.scrollToElement(userLink).perform();
		userLink.click();
	}
	
}
