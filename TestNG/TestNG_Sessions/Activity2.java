package TestNG_Sessions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class Activity2 {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }
  
	 //Test Case 1 will pass 
  @Test
  public void testCase1() {
	  String title = driver.getTitle();
      System.out.println("Title is: " + title);
      Assert.assertEquals(title, "Target Practice");
  }
  
	 //Test Case 2 will fail 
  @Test
  public void testCase2() {
	  WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
      Assert.assertTrue(blackButton.isDisplayed());
      Assert.assertEquals(blackButton.getText(), "black");
  }
  
	 //Test Case 3 will be skipped and not counted
  @Test(enabled = false)
  public void testCase3() {
	  String subHeading = driver.findElement(By.className("sub")).getText();
      Assert.assertTrue(subHeading.contains("Practice"));
  }
  
	 //Test Case 4 will be skipped and shown as skipped
  @Test
  public void testCase4() {
	  throw new SkipException("Skipping test case");
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}