package hms.Integration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hms.generic.fileutlity.BaseClass;
import hms.objectrepositoryutility.AdminDashboardPage;
import hms.objectrepositoryutility.AdminLoginPage;
import hms.objectrepositoryutility.DoctorDashboardPage;
import hms.objectrepositoryutility.DoctorLoginPage;
import junit.framework.Assert;


@Listeners(hms.generic.fileutlity.ListImpclass.class)
public class UpdateDoctorDetails extends BaseClass {

	@Test(groups="regressionTest")
	public void manageDoctor() throws Throwable {

		AdminLoginPage alp = new AdminLoginPage(driver);
		String URL = fLib.toReadDatafromPropertyfile("url");
		String ADMINUSERNAME = fLib.toReadDatafromPropertyfile("adminusername");
		String ADMINPASSWORD = fLib.toReadDatafromPropertyfile("adminpassword");
		alp.logintoAdmin(URL, ADMINUSERNAME, ADMINPASSWORD);

		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.manageDoctor();

		WebElement DocEdtIcon = driver
				.findElement(By.xpath("//a[@href='manage-doctors.php?id=120&del=delete']/preceding-sibling::a"));
		wLib.clickElementJavaExecutor(driver, DocEdtIcon);

		WebElement ContactTextField = adp.getAdminDrupdate();
		wLib.clickElementJavaExecutor(driver, ContactTextField);

		Thread.sleep(3000);
		// String edtiContact = eLib.getDataFromExcel("Sheet2", 1, 2);
		// String editAddress = eLib.getDataFromExcel("Sheet2", 1, 3);
		adp.editDocDetails();

		adp.adminLogout();
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		String DOCTORUSERNAME = fLib.toReadDatafromPropertyfile("doctorusername");
		String DOCTORPASSWORD = fLib.toReadDatafromPropertyfile("doctorpassword");
		dlp.logintoDoctor(DOCTORUSERNAME, DOCTORPASSWORD);

		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getDrMyUpdateProfile().click();
		String updatedDRAdd = adp.getDoctorscliniaddress().getText();
		String updatedDRContact = adp.getDoctorscontact().getAttribute("value");

		Assert.assertEquals(updatedDRAdd, "Bangalore");
		Assert.assertEquals("7430025729", updatedDRContact);

	}

}
