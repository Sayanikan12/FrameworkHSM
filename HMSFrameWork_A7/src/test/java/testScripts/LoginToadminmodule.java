package testScripts;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hms.generic.fileutlity.BaseClass;
import hms.generic.fileutlity.FileUtility;
import hms.objectrepositoryutility.AdminDashboardPage;
import hms.objectrepositoryutility.AdminLoginPage;

@Listeners(hms.generic.fileutlity.ListImpclass.class)

public class LoginToadminmodule extends BaseClass{
		
	@Test(groups="smokeTest")
	
	public void adminLogin() throws IOException, InterruptedException {
		
		AdminLoginPage alp=new AdminLoginPage(driver);
		String URL =fLib.toReadDatafromPropertyfile("url");
		String ADMINUSERNAME =fLib.toReadDatafromPropertyfile("adminusername");
		String ADMINPASSWORD =fLib.toReadDatafromPropertyfile("adminpassword");
        alp.logintoAdmin(URL, ADMINUSERNAME, ADMINPASSWORD);
        System.out.println("Login to the usermodule successfully");
        String expectedData="ADMIN | DASHBOARD";
        
        AdminDashboardPage adp=new AdminDashboardPage(driver);
      String adminHeader = adp.getAdminHeader().getText();
      System.out.println(adminHeader);
      Assert.assertTrue(adminHeader.contains(expectedData));
	}

}
