package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2_3 {
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
      
      driver.get("https://www.training-support.net/selenium");
      wait.until(ExpectedConditions.visibilityOf
    		  (driver.findElementByClassName("android.view.View")));
      
      //Click on Popups card
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("UiScrollable(UiSelector().scrollable(true))."
			  		+ "scrollIntoView(textContains(\"Popups\"))")).click();
	  
	  wait.until(ExpectedConditions.visibilityOf
    		  (driver.findElementByXPath("//android.widget.TextView[@text='Popups']")));
  }

  @Test
  public void correctLogin(){	  
	  driver.findElement
	  (MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
	  
	  wait.until(ExpectedConditions.visibilityOf
			  (driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")"))));
	  
	  MobileElement username = driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"username\")"));
	  MobileElement password = driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"password\")"));
	  
	  username.sendKeys("admin");
	  password.sendKeys("password");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"))));
	  
	  MobileElement message = driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"));
	  
	  Assert.assertEquals(message.getText(), "Welcome Back, admin");
  }

  @Test
  public void incorrectLogin(){
	  driver.findElement
	  (MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
	  
	  wait.until(ExpectedConditions.visibilityOf
			  (driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")"))));
	  
	  MobileElement username = driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"username\")"));
	  MobileElement password = driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"password\")"));
	  
	  username.sendKeys("admin");
	  password.sendKeys("p@$$w0rd");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"))));
	  
	  MobileElement message = driver.findElement
			  (MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"));
	  
	  Assert.assertEquals(message.getText(), "Invalid Credentials");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}