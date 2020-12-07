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

public class Activity1_2 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "86S7N18923002526");
      caps.setCapability("deviceName", "Huawei P20 Lite");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      caps.setCapability("noReset", true);

      URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(serverURL, caps);
      wait = new WebDriverWait(driver, 5);
  }

  @Test
  public void addNote() {
	  //Add Note
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"New text note\")")).click();	  
	  //Add Title
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Title\")"))
	  .sendKeys("Title for Note");
	  //Add Description
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Note\")"))
	  .sendKeys("Description for Note");
	  //Click back button
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("description(\"Open navigation drawer\")")).click();
	  //Assert Note is added
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.keep:id/browse_note_interior_content\")")));
	  
	  String title = driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.keep:id/index_note_title\")")).getText();
	  String desc = driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.keep:id/index_note_text_description\")")).getText();
	  
	  Assert.assertEquals(title, "Title for Note");
	  Assert.assertEquals(desc, "Description for Note");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}