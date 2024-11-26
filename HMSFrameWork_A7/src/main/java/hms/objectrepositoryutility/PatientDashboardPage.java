package hms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.generic.fileutlity.JavaUtility;

public class PatientDashboardPage {
	
	WebDriver driver;

	public PatientDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Book Appointment '] ")
	private WebElement patientBookAppon;
	
	@FindBy(name="Doctorspecialization")
	private WebElement drSpidrpfild;
	
	
	@FindBy(name="doctor")
	private WebElement drName;
	
	@FindBy(name="fee")
	private WebElement drFees;
	
	
	@FindBy(xpath="//input[@name='appdate']")
	private WebElement dateOfAppoinment;
	
	@FindBy(xpath="//input[@name='apptime']")
	private WebElement timeOfAppoinment;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitbtn;
	
	
	@FindBy(xpath="//h1[text()='User | Dashboard']")
	private WebElement userHeader;
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement appointHistoryLink;

	public WebElement getAppointHistoryLink() {
		return appointHistoryLink;
	}
	
	public WebElement getPatientBookAppon() {
		return patientBookAppon;
	}



	public WebElement getDrSpidrpfild() {
		return drSpidrpfild;
	}



	public WebElement getDrName() {
		return drName;
	}



	public WebElement getDrFees() {
		return drFees;
	}



	public WebElement getDateOfAppoinment() {
		return dateOfAppoinment;
	}



	public WebElement getTimeOfAppoinment() {
		return timeOfAppoinment;
	}



	public WebElement getSubmitbtn() {
		return submitbtn;
	}



	public WebElement getUserHeader() {
		return userHeader;
	}



	public void bookApponment() {
		patientBookAppon.click();
		drSpidrpfild.click();
		Select select=new Select(drSpidrpfild);
		select.selectByIndex(0);
		drName.click();
		/*Select select1=new Select(drName);
		select1.selectByIndex(0);
		dateOfAppoinment.sendKeys("2024-11-27");
		timeOfAppoinment.click();
		timeOfAppoinment.sendKeys("4.30PM");*/
		
		//submitbtn.click();
		
	}
public void clickAppointHistory() {
		
		appointHistoryLink.click();
}
	

}
