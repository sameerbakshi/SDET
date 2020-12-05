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

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity3_1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
  @BeforeClass
  public void setup() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "86S7N18923002526");
      caps.setCapability("deviceName", "Huawei P20 Lite");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.mms");
      caps.setCapability("appActivity", ".ui.ConversationList");
      caps.setCapability("noReset", true);
      
      URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(serverURL, caps);
      wait = new WebDriverWait(driver, 5);
  }
  
  @Test
  public void smsTest() {
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"New message\")")).click();
	  
	  String contactBoxLocator = "resourceId(\"com.android.mms:id/recipients_editor\")";
	  driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("7760917030");
	  
	  driver.hideKeyboard();
	  
	  String messageBoxLocator = "resourceId(\"com.android.mms:id/embedded_text_editor\")";
	  driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).sendKeys("Hello from Appium");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send\")")).click();
      
	  String messageLocator = "resourceId(\"com.android.mms:id/text_view\")";
      String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
      Assert.assertEquals(sentMessageText, "Hello from Appium");
  }
  
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
 
}