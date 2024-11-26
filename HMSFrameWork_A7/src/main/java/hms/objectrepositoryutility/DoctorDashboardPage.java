package hms.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {

	WebDriver driver;

	public DoctorDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-sm-8']/h1[text()='Doctor | Dashboard']")
	private WebElement DrHeader;
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientLink;
	
	@FindBy(xpath = " //span[text()=' Add Patient']")
	private WebElement addPatientLink;
	
	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement managePatientLink;
	
	@FindBy(xpath = " //span[text()=' Search ']")
	private WebElement searchPatientLink;
	
	@FindBy(id="searchdata")
	private WebElement searchtextfild;
	
	@FindBy(id="submit")
	private WebElement searchBtn;
	
	@FindBy(name = "patname")
	private WebElement patientName;
	
	@FindBy(name = "patcontact")
	private WebElement patientCont;
	
	@FindBy(name="patemail")
	private WebElement patientEmail;
	
	@FindBy(name="pataddress")
	private WebElement patientAdd;
	
	@FindBy(name="patage")
	private WebElement patientAge;
	
	@FindBy(name="medhis")
	private WebElement patientMedHis;
	
	@FindBy(name="submit")
	private WebElement addBtn;
	
	@FindBy(xpath="//label[@for='rg-female']")
	private WebElement patientGender;
	
	@FindBy(partialLinkText="Update Profile")
	private WebElement drMyUpdateProfile;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement doctorLogoutLink;

	@FindBy(partialLinkText="Log Out")
	private WebElement doctorLogoutbtn;
	

	public WebElement getSearchPatientLink() {
		return searchPatientLink;
	}


	public WebElement getSearchtextfild() {
		return searchtextfild;
	}


	public WebElement getSearchBtnName() {
		return searchBtn;
	}


	public WebElement getManagePatientLink() {
		return managePatientLink;
	}


	public WebElement getDrMyUpdateProfile() {
		return drMyUpdateProfile;
	}


	public WebElement getDrHeader() {
		return DrHeader;
	}


	public WebElement getPatientLink() {
		return patientLink;
	}


	public WebElement getAddPatientLink() {
		return addPatientLink;
	}


	public WebElement getPatientName() {
		return patientName;
	}


	public WebElement getPatientCont() {
		return patientCont;
	}


	public WebElement getPatientEmail() {
		return patientEmail;
	}


	public WebElement getPatientAdd() {
		return patientAdd;
	}


	public WebElement getPatientAge() {
		return patientAge;
	}


	public WebElement getPatientMedHis() {
		return patientMedHis;
	}


	public WebElement getAddBtn() {
		return addBtn;
	}


	public WebElement getPatientGender() {
		return patientGender;
	}

	public WebElement getDoctorLogoutLink() {
		return doctorLogoutLink;
	}


	public WebElement getDoctorLogoutbtn() {
		return doctorLogoutbtn;
	}


	public void addPatient() throws InterruptedException {
		patientLink.click();
		Thread.sleep(4000);
		addPatientLink.click();
		Thread.sleep(4000);
	}
	public void addPatientDetails(String patiName, String patiContact,String patientemail,String patiAdd,String patiAge,String patiMedHis) {
		patientName.sendKeys(patiName);
		patientCont.sendKeys(patiContact);
		patientEmail.sendKeys(patientemail);
		patientGender.click();
		patientAdd.sendKeys(patiAdd);
		patientAge.sendKeys(patiAge);
		patientMedHis.sendKeys(patiMedHis);
		addBtn.click();
	}
	
	public void doctorLogout() throws InterruptedException {
		driver.manage().window().minimize();
		doctorLogoutLink.click();
		Thread.sleep(2000);
		doctorLogoutbtn.click();
		}
	
	public void searchPatient(String patientname) throws InterruptedException {
		searchPatientLink.click();
		searchtextfild.sendKeys(patientname);
		Thread.sleep(2000);
		searchBtn.click();
	}

}
