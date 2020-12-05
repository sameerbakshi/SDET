package Appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity1_2 {
    AppiumDriver<MobileElement> driver = null;
  @Test
  public void calculator() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "86S7N18923002526");
      caps.setCapability("deviceName", "Huawei P20 Lite");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.calculator2");
      caps.setCapability("appActivity", "com.android.calculator2.Calculator");

      URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(serverURL, caps);
	  System.out.println("Calculator is open");
  }
 
}