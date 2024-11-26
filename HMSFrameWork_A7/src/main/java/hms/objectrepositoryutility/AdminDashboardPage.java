package hms.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.generic.fileutlity.WebDriverUtility;

/**
 * 
 */
public class AdminDashboardPage {
	
	WebDriver driver;
	public AdminDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText="Admin")
	private WebElement adminLogoutLink;

	@FindBy(partialLinkText="Log Out")
	private WebElement adminLogoutbtn;
	
	@FindBy(xpath="//div[@class='col-sm-8']/h1[text()='Admin | Dashboard']")
	private WebElement adminHeader;
	
	@FindBy(xpath="//div[@class='col-sm-8']/h1[text()='Admin | Manage Doctors']")
	private WebElement manageDrHeader;
	
	@FindBy(xpath="//span[text()=' Doctor Specialization ']")
	private WebElement adminAddDrSpi; 
	
	public WebElement getManageDrHeader() {
		return manageDrHeader;
	}

	@FindBy(xpath="//span[text()=' Doctors ']")
	private WebElement adminDoctors;
	
	@FindBy(xpath="//span[text()=' Add Doctor']")
	private WebElement addDoctorslink;
	
	@FindBy(name="Doctorspecialization")
	private WebElement DoctorsspecialLink;
	
	@FindBy(xpath="//span[text()=' Manage Doctors ']")
	private WebElement adminManaDoctors;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement adminDrupdate;
	
	
	@FindBy(name="docname")
	private WebElement Doctornametextfild;
	
	@FindBy(name="clinicaddress")
	private WebElement Doctorscliniaddress;
	
	@FindBy(name="docfees")
	private WebElement Doctorsfees;
	
	@FindBy(name="doccontact")
	private WebElement Doctorscontact;
	
	@FindBy(name="docemail")
	private WebElement Doctorsemail;
	
	@FindBy(name="npass")
	private WebElement Doctorspassword;
	
	@FindBy(name="cfpass")
	private WebElement Doctorsconpass;
	
	@FindBy(name="submit")
	private WebElement Doctorsubmitbtn;
	
	@FindBy(name="doctorspecilization")
	private WebElement AddDoctorSpitextfild;
	
	@FindBy(name="submit")
	private WebElement AddDoctorSpisubmitbtn;
	

	
	public WebElement getAdminLogoutLink() {
		return adminLogoutLink;
	}

	public WebElement getAdminLogoutbtn() {
		return adminLogoutbtn;
	}
	
	public WebElement getAdminHeader() {
		return adminHeader;
	}

	public WebElement getAdminDoctors() {
		return adminDoctors;
	}

	public WebElement getAddDoctorslink() {
		return addDoctorslink;
	}

	public WebElement getDoctorsspecialLink() {
		return DoctorsspecialLink;
	}

	public WebElement getDoctornametextfild() {
		return Doctornametextfild;
	}

	public WebElement getDoctorscliniaddress() {
		return Doctorscliniaddress;
	}

	public WebElement getDoctorsfees() {
		return Doctorsfees;
	}

	public WebElement getDoctorscontact() {
		return Doctorscontact;
	}

	public WebElement getDoctorsemail() {
		return Doctorsemail;
	}

	public WebElement getDoctorspassword() {
		return Doctorspassword;
	}

	public WebElement getDoctorsconpass() {
		return Doctorsconpass;
	}

	public WebElement getDoctorsubmitbtn() {
		return Doctorsubmitbtn;
	}

public WebElement getAddDoctorSpitextfild() {
		return AddDoctorSpitextfild;
	}

public WebElement getAdminAddDrSpi() {
		return adminAddDrSpi;
	}

public WebElement getAddDoctorSpisubmitbtn() {
	return AddDoctorSpisubmitbtn;
}

public WebElement getAdminManaDoctors() {
	return adminManaDoctors;
}

public void addDoctorDetails(String doctName,String clinAddress,String doctFees,String doctContact,String doctEmail,String doctPass,String conPass) throws InterruptedException {
	DoctorsspecialLink.click();
	Select select=new Select(DoctorsspecialLink);
	select.selectByIndex(3);
	Doctornametextfild.sendKeys(doctName);
	Doctorscliniaddress.sendKeys(clinAddress);
	Doctorsfees.sendKeys(doctFees);
	Doctorscontact.sendKeys(doctContact);
	Doctorsemail.sendKeys(doctEmail);
	Doctorspassword.sendKeys(doctPass);
	Doctorsconpass.sendKeys(conPass);
	Doctorsubmitbtn.sendKeys(conPass);
  WebDriverUtility wb=new WebDriverUtility();
  wb.toMaximizeWindow(driver);
	Doctorsubmitbtn.click();
	driver.switchTo().alert().accept();;
	
}

public void adminLogout() throws InterruptedException {
	driver.manage().window().minimize();
	adminLogoutLink.click();
	Thread.sleep(2000);
	adminLogoutbtn.click();
	
}

public void drSpeciAdd() throws InterruptedException {
	adminDoctors.click();
	Thread.sleep(3000);
	adminAddDrSpi.click();
	Thread.sleep(3000);
}

public void addDoctor() throws InterruptedException {
	adminDoctors.click();
	Thread.sleep(5000);
	addDoctorslink.click();
}

public void addDoctorSpic(String Drspicali) throws InterruptedException {
	AddDoctorSpitextfild.sendKeys(Drspicali);
	AddDoctorSpisubmitbtn.click();
	Thread.sleep(2000);
	adminDoctors.click();
	Thread.sleep(4000);
	addDoctorslink.click();
	}
public void manageDoctor() throws InterruptedException {
	adminDoctors.click();
	Thread.sleep(5000);
	adminManaDoctors.click();
}
public void editDocDetails() throws InterruptedException {
	Doctorscliniaddress.clear();
	Doctorscliniaddress.sendKeys("Bangalore");
	Doctorscontact.clear();
	Doctorscontact.sendKeys("7430025729");
	Thread.sleep(5000);
	adminDrupdate.click();
}

public WebElement getAdminDrupdate() {
	return adminDrupdate;
}
}
