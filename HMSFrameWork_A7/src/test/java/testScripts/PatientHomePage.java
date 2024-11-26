package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hms.generic.fileutlity.BaseClass;
import hms.objectrepositoryutility.PatientDashboardPage;
import hms.objectrepositoryutility.UserLoginPage;



@Listeners(hms.generic.fileutlity.ListImpclass.class)
public class PatientHomePage extends BaseClass {
	@Test(groups="smokeTest")
	public void login() throws IOException, InterruptedException {
		UserLoginPage ulp=new UserLoginPage(driver);
		String URL =fLib.toReadDatafromPropertyfile("url");
		String USERUSERNAME =fLib.toReadDatafromPropertyfile("userusername");
		String USERPASSWORD =fLib.toReadDatafromPropertyfile("userpassword");
		ulp.logintoUser(URL, USERUSERNAME, USERPASSWORD);
		System.out.println("Login to the usermodule successfully");
		String expectedData="USER | DASHBOARD";
		PatientDashboardPage pdp=new PatientDashboardPage(driver);
		String userHeader =pdp.getUserHeader().getText();
	      Assert.assertTrue(userHeader.contains(expectedData));
	}
}
