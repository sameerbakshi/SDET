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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity2_3 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
  @BeforeClass
  public void setup() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "86S7N18923002526");
      caps.setCapability("deviceName", "Huawei P20 Lite");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.contacts");
      caps.setCapability("appActivity", ".activities.DialtactsActivity");
      caps.setCapability("noReset", true);
      
      URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(serverURL, caps);
      wait = new WebDriverWait(driver, 5);
  }
  
  @Test
  public void addContact() {
	  driver.findElementByAccessibilityId("New contact").click();
	  
	  driver.findElementByXPath("//android.widget.EditText[@text='Name']").click();
	  MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
      driver.hideKeyboard();
      MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone number']");
      
      firstName.sendKeys("Aaditya");
      lastName.sendKeys("Varma");
      phoneNumber.sendKeys("9991284782");
      
      driver.findElementByXPath("//android.widget.ImageView[@content-desc='Done']").click();
      
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Photo")));      
      MobileElement mobileCard = driver.findElement(MobileBy.AccessibilityId("Photo"));
      Assert.assertTrue(mobileCard.isDisplayed());
      
      String contactName = driver.findElementById("name").getText();
      Assert.assertEquals(contactName, "Aaditya Varma");
  }
  
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
 
}