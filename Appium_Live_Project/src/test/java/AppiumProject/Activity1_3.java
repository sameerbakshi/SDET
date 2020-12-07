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

public class Activity1_3 {
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
  public void addReminder() {
	  //Add Note
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"New text note\")")).click();	  
	  //Add Title
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Title\")"))
	  .sendKeys("Title for Reminder");
	  //Add Description
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Note\")"))
	  .sendKeys("Description for Reminder");
	  
	  //Add reminder
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Reminder\")")).click();
	  //Set reminder time to 12 AM
	  driver.findElement(MobileBy.xpath
			  ("//android.widget.LinearLayout[contains(@content-desc,\"Time\")]"
			  		+ "/android.widget.Spinner/android.widget.TextView")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated
			  (MobileBy.AndroidUIAutomator("text(\"Select a time…\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("text(\"Select a time…\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("description(\"12\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"android:id/am_label\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("text(\"OK\")")).click();
	  //Save the reminder
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
	  
	  //Click back button
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator
			  ("description(\"Open navigation drawer\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("description(\"Open navigation drawer\")")).click();
	  
	  //Assert Reminder is added
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.keep:id/browse_note_interior_content\")")));
	  
	  String title = driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.keep:id/index_note_title\")")).getText();
	  String desc = driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.keep:id/index_note_text_description\")")).getText();
	  String reminder = driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.keep:id/reminder_chip_text\")")).getText();
	  
	  Assert.assertEquals(title, "Title for Reminder");
	  Assert.assertEquals(desc, "Description for Reminder");
	  Assert.assertEquals(reminder, "Tomorrow, 12:00 AM");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}