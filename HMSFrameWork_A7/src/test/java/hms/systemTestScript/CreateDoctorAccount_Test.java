package hms.systemTestScript;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hms.generic.fileutlity.BaseClass;
import hms.generic.fileutlity.JavaUtility;
import hms.objectrepositoryutility.AdminDashboardPage;
import hms.objectrepositoryutility.AdminLoginPage;
import hms.objectrepositoryutility.DoctorDashboardPage;
import hms.objectrepositoryutility.DoctorLoginPage;



@Listeners(hms.generic.fileutlity.ListImpclass.class)
public class CreateDoctorAccount_Test extends BaseClass{
	
	@Test(groups="regressionTest")
	public void createDoctor_Test() throws Throwable {
		AdminLoginPage alp=new AdminLoginPage(driver);
		String URL =fLib.toReadDatafromPropertyfile("url");
		String ADMINUSERNAME =fLib.toReadDatafromPropertyfile("adminusername");
		String ADMINPASSWORD =fLib.toReadDatafromPropertyfile("adminpassword");
        alp.logintoAdmin(URL, ADMINUSERNAME, ADMINPASSWORD);
        System.out.println("Login to the usermodule successfully");
        
        String expectedData="DOCTOR | DASHBOARD";
      
        //click on doctor module
        JavaUtility ju=new JavaUtility();
        
        AdminDashboardPage adp=new AdminDashboardPage(driver);
       String doctName = eLib.getDataFromExcel("Doctor", 1, 1);
       String doctAdd = eLib.getDataFromExcel("Doctor", 1, 2);
       String doctFee = eLib.getDataFromExcel("Doctor", 1, 3);
       String doctContact = eLib.getDataFromExcel("Doctor", 1, 4);
       String doctEmail = eLib.getDataFromExcel("Doctor", 1, 5)+ju.getRandomNumber();
       String doctPass = eLib.getDataFromExcel("Doctor", 1, 6);
       String doctConPass = eLib.getDataFromExcel("Doctor", 1, 7);
       adp.addDoctor();
       Thread.sleep(5000);
       adp.addDoctorDetails(doctName, doctAdd, doctFee, doctContact, doctEmail, doctPass, doctConPass);
      
       adp.adminLogout();
       
       DoctorLoginPage dp=new DoctorLoginPage(driver);
       String DOCTORUSERNAME =System.getProperty("PASSWORD", fLib.toReadDatafromPropertyfile("doctorusername"));
   	String DOCTORPASSWORD =System.getProperty("PASSWORD", fLib.toReadDatafromPropertyfile("doctorpassword"));
       dp.logintoDoctor(URL, DOCTORUSERNAME, DOCTORPASSWORD);
       DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
       String drHeader = ddp.getDrHeader().getText().trim();
       Assert.assertEquals(drHeader, expectedData);
       
       
	}
}
