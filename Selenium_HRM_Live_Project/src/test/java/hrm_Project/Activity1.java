package hrm_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	//Initialize driver and wait
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);

  @BeforeMethod
  public void beforeMethod() {
  //Launch the website
  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
  
  @Test
  public void testActivity1() {
	  //wait for the landing page
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInPanelHeading")));	  
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
      }

  @AfterMethod
  public void afterMethod() {
	  //Close the driver
	  driver.close();
  }

}