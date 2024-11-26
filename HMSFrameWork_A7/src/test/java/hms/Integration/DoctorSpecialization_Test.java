package hms.Integration;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hms.generic.fileutlity.BaseClass;
import hms.objectrepositoryutility.AdminDashboardPage;
import hms.objectrepositoryutility.AdminLoginPage;


@Listeners(hms.generic.fileutlity.ListImpclass.class)
public class DoctorSpecialization_Test extends BaseClass {

	@Test(groups="regressionTest")
	public void doctorSpecialization() throws Throwable {
		AdminLoginPage alp = new AdminLoginPage(driver);
		String URL = fLib.toReadDatafromPropertyfile("url");
		String ADMINUSERNAME = fLib.toReadDatafromPropertyfile("adminusername");
		String ADMINPASSWORD = fLib.toReadDatafromPropertyfile("adminpassword");
		alp.logintoAdmin(URL, ADMINUSERNAME, ADMINPASSWORD);
		System.out.println("Login to the usermodule successfully");

		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.drSpeciAdd();
		String drSpicAdd = eLib.getDataFromExcel("Drspicdetails", 1, 1);
		adp.addDoctorSpic(drSpicAdd);
		System.out.println(drSpicAdd);
		WebElement doctorsspecialLink = adp.getDoctorsspecialLink();
		adp.getDoctorsspecialLink().click();
		
		Thread.sleep(3000);
		
		Select select = new Select(doctorsspecialLink);
		List<WebElement> allDrSpeciOptions = select.getOptions();
		
		Thread.sleep(3000);
		String expected=null;
		boolean flag=false;
		
		for(WebElement ele:allDrSpeciOptions) {
			expected=ele.getText();
			if(expected.contains(drSpicAdd)) {
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag);
		/*
		 * if(allDrSpeciOptions.contains(drSpicAdd)) {
		 * System.out.println("Doctor Specialization added successfully"); } else {
		 * System.out.println("Doctor Specialization added successfully"); }
		 */

	}
}
