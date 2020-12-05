package Appium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity2_2 {
	AppiumDriver<MobileElement> driver = null;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "86S7N18923002526");
      caps.setCapability("deviceName", "Huawei P20 Lite");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.calculator2");
      caps.setCapability("appActivity", "com.android.calculator2.Calculator");

      URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(serverURL, caps);
  }
  
  @Test
  public void add() {
	  driver.findElementById("digit_5").click();
      driver.findElementById("op_add").click();
      driver.findElementById("digit_9").click();
      driver.findElementById("eq").click();
      
      String result = driver.findElementById("formula").getText();
      System.out.println(result);
      Assert.assertEquals(result, "14");
  }
  
  @Test
  public void subtract() {
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
      driver.findElementById("op_sub").click();
      driver.findElementById("digit_5").click();
      driver.findElementById("eq").click();
      
      String result = driver.findElementById("formula").getText();
      System.out.println(result);
      Assert.assertEquals(result, "5");
  }
  
  @Test
  public void multiply() {
      driver.findElementById("digit_5").click();
      driver.findElementById("op_mul").click();
      driver.findElementById("digit_1").click();
      driver.findElementById("digit_0").click();
      driver.findElementById("digit_0").click();
      driver.findElementById("eq").click();

      String result = driver.findElementById("formula").getText();
      System.out.println(result);
      Assert.assertEquals(result, "500");
  }
  
  @Test
  public void divide() {
      driver.findElementById("digit_5").click();
      driver.findElementById("digit_0").click();
      driver.findElementById("op_div").click();
      driver.findElementById("digit_2").click();
      driver.findElementById("eq").click();

      String result = driver.findElementById("formula").getText();
      System.out.println(result);
      Assert.assertEquals(result, "25");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
 
}