package hms.systemTestScript;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hms.generic.fileutlity.BaseClass;
import hms.objectrepositoryutility.DoctorDashboardPage;
import hms.objectrepositoryutility.DoctorLoginPage;


@Listeners(hms.generic.fileutlity.ListImpclass.class)
public class Addpatient_Test extends BaseClass{
	
	@Test(groups="regressionTest")
	public void addPatient() throws Throwable {
		
	
	 DoctorLoginPage dp=new DoctorLoginPage(driver);
	 String URL =fLib.toReadDatafromPropertyfile("url");
     String DOCTORUSERNAME =fLib.toReadDatafromPropertyfile("doctorusername");
 	String DOCTORPASSWORD =fLib.toReadDatafromPropertyfile("doctorpassword");
 	dp.logintoDoctor(URL, DOCTORUSERNAME, DOCTORPASSWORD);
 	
 	DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
 	ddp.addPatient();
 	
 	 String patiName = eLib.getDataFromExcel("Patient", 1, 1)+ju.getRandomNumber();
     String patiContact = eLib.getDataFromExcel("Patient", 1, 2);
     String patientEmail = eLib.getDataFromExcel("Patient", 1, 3)+ju.getRandomNumber();
     String patientAdd = eLib.getDataFromExcel("Patient", 1, 4);
     String patientAge = eLib.getDataFromExcel("Patient", 1, 5);
     String patientMedHis = eLib.getDataFromExcel("Patient", 1, 6);
 	ddp.addPatientDetails(patiName, patiContact, patientEmail, patientAdd, patientAge, patientMedHis);
 	//validation
 	ddp.searchPatient(patiName);
 	Assert.assertTrue(driver.findElement(By.xpath("//td[text()='"+patiName+"']")).isDisplayed());	
	}

}
