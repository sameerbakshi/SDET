package TestNG_Sessions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity3 {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
      driver.get("https://www.training-support.net/selenium/login-form");
  }

  @Test
  public void loginTest() {
	  WebElement username = driver.findElement(By.id("username"));
      WebElement password = driver.findElement(By.id("password"));
      
      username.sendKeys("admin");
      password.sendKeys("password");
      
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
      
      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
      Assert.assertEquals("Welcome Back, admin", loginMessage);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
