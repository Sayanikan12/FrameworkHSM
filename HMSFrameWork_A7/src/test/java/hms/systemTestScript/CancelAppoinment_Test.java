package hms.systemTestScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hms.generic.fileutlity.BaseClass;
import hms.objectrepositoryutility.PatientDashboardPage;
import hms.objectrepositoryutility.UserLoginPage;


@Listeners(hms.generic.fileutlity.ListImpclass.class)
public class CancelAppoinment_Test extends BaseClass {
	
	@Test(groups="regressionTest")
	
	public void cancelAppointmentByUser() throws Throwable {
		String URL = fLib.toReadDatafromPropertyfile("url");
		String USERUSERNAME =fLib.toReadDatafromPropertyfile("userusername");
		String USERPASSWORD =fLib.toReadDatafromPropertyfile("userpassword");
		System.out.println("login successfully");
		UserLoginPage ulp=new UserLoginPage(driver);
		ulp.logintoUser(URL, USERUSERNAME, USERPASSWORD);
		
		PatientDashboardPage pdp=new PatientDashboardPage(driver);
		pdp.clickAppointHistory();
		
		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[contains(.,'Aapti')]/td[8]")).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		
		
		
		
	}
	

}
