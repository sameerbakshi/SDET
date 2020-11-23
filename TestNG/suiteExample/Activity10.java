package suiteExample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity10 {
	WebDriver driver;
    Actions builder;
    
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
      builder = new Actions(driver);
      
      driver.get("https://www.training-support.net/selenium/sliders");
      driver.manage().window().maximize();
  }

  @Test
  public void sliderToMiddleTest() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  slider.click();
	  
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Mid value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "50");
  }
  
  @Test
  public void sliderToMaxTest() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(80, 0).release().build().perform();
	  
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Max value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "100");
  }
  
  @Test
  public void sliderToMinTest() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(-80, 0).release().build().perform();
	  
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Min value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "0");
  }

  @Test
  public void sliderTo30Test() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(-32, 0).release().build().perform();
	  
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Slider value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "30");
  }

  @Test
  public void sliderTo80Test() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(48, 0).release().build().perform();
	  
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Slider value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "80");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}