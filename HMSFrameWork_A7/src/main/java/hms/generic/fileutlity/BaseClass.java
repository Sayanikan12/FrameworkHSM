package hms.generic.fileutlity;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import hms.objectrepositoryutility.AdminLoginPage;




public class BaseClass {
	
	public ExcelUlitity eLib=new ExcelUlitity();
    public FileUtility fLib = new FileUtility();
    public  JavaUtility ju=new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver=null;
	public WebDriverUtility wLib=new WebDriverUtility();	
	@BeforeSuite
	public void configDB() {
		System.out.println("Connect to database");
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC(@Optional("chrome") String browser) throws IOException {
				System.out.println("===Launch the Browser===");
				String BROWSER=fLib.toReadDatafromPropertyfile("browser");
				if (BROWSER.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else if (BROWSER.equalsIgnoreCase("edge")) {
					driver = new EdgeDriver();
				} else {
					driver = new ChromeDriver();
				}
	sdriver=driver;
	}
@AfterMethod(groups= {"smokeTest","regressionTest"})

public void configAM() {
	System.out.println("==Logout the application==");	
	
}

@AfterClass(groups= {"smokeTest","regressionTest"})
public void configAC() {
	System.out.println("==Tear Down The Browser==");
	driver.quit();
	
}

@AfterSuite(groups= {"smokeTest","regressionTest"})
public void configAS() throws SQLException {
	System.out.println("===Close DB connection, report Backup===");

}
}
