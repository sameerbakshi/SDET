package Appium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity3_2 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "86S7N18923002526");
      caps.setCapability("deviceName", "Huawei P20 Lite");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("noReset", true);

      URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(serverURL, caps);
      wait = new WebDriverWait(driver, 5);
      
      driver.get("https://www.training-support.net/selenium/lazy-loading");
      wait.until(ExpectedConditions.visibilityOf(driver.findElementByClassName("android.view.View")));
  }
  
  @Test
  public void imageScrollTest() {	  
      MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
      wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
      
      List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
      System.out.println("Number of image shown currently: " + numberOfImages.size());
      
      Assert.assertEquals(numberOfImages.size(), 2);
      
      driver.findElementByClassName("android.view.View").click();
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"helen\")"));
      
      numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
      System.out.println("Number of image shown currently: " + numberOfImages.size());
      
      Assert.assertEquals(numberOfImages.size(), 4);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
 
}