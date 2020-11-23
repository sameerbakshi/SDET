package hrm_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	Actions actions = new Actions(driver);
	
	@BeforeClass
	public void beforeClass() {
	//Launch the website
	driver.get("http://alchemy.hguy.co/orangehrm");
	
	//Fill in the login credentials
	WebElement username=driver.findElement(By.id("txtUsername"));
	WebElement password=driver.findElement(By.id("txtPassword"));
	username.sendKeys("orange");
	password.sendKeys("orangepassword123");
		  
	//Click on the login button
	driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test
	public void testActivity6() {
		//Wait for menu to load		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
		
		//Verify Directory is visible
		Assert.assertTrue(driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed());
		
		//Verify Directory is clickable
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu_directory_viewDirectory"))));
		
		//Click on Directory
		driver.findElement(By.id("menu_directory_viewDirectory")).click();
		  
		//Verify page header matches "Search Directory"
		Assert.assertEquals(driver.findElement(By.className("head")).getText(),"Search Directory");
	}

	@AfterClass
	public void afterClass() {
	  //Close the driver
	  driver.close();
  }

}