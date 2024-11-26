package hms.generic.fileutlity;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void toLoadPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void waitForElementtoClick(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	public void waitForElementtoVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public void toMaximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void toSwitchWindow(WebDriver driver, String partialurl) {
		Set<String> allWindowID = driver.getWindowHandles();
		for(String window: allWindowID) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains(partialurl)){
				break;
			}
		}
	}
	
	public void clickElementJavaExecutor(WebDriver driver,  WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}
	
	

}
