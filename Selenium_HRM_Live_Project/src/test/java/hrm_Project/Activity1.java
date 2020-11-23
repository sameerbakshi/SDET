package hrm_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	//Initialize driver and wait
	WebDriver driver;
	WebDriverWait wait;

  @BeforeClass
  public void beforeClass() {
  //Launch the website
	  	driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,10);
		driver.get("http://alchemy.hguy.co/orangehrm");
	  }
  
  @Test
  public void testActivity1() {
	  //wait for the landing page
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInPanelHeading")));	  
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
      }

  @AfterClass
  public void afterClass() {
	  //Close the driver
	  driver.close();
  }

}