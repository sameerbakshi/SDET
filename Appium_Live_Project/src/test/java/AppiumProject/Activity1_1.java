package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1_1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "86S7N18923002526");
      caps.setCapability("deviceName", "Huawei P20 Lite");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);

      URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(serverURL, caps);
      wait = new WebDriverWait(driver, 5);
  }

  @Test
  public void addTasks() {
	  //Add first task
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create new task\")")).click();	  
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"New task\")"))
	  .sendKeys("Complete Activity with Google Tasks");
	  driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.
			  AndroidUIAutomator("description(\"Create new task\")")));
	  
	  //Add second task
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create new task\")")).click();  
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"New task\")"))
	  .sendKeys("Complete Activity with Google Keep");
	  driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.
			  AndroidUIAutomator("description(\"Create new task\")")));
	  
	  //Add third task
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create new task\")")).click();	  
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"New task\")"))
	  .sendKeys("Complete the second Activity Google Keep");
	  driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.
			  AndroidUIAutomator("description(\"Create new task\")")));
	  
	  //Assert all 3 tasks are added
	  List<MobileElement> tasks = driver.findElements(MobileBy.AndroidUIAutomator
			  ("resourceId(\"com.google.android.apps.tasks:id/task_name\")"));
	  
	  int i=3;
	  Assert.assertEquals(tasks.size(), i);
	  for(MobileElement task:tasks) {
		  if(i==1)
			  Assert.assertEquals(task.getText(), "Complete Activity with Google Tasks");
		  if(i==2)
			  Assert.assertEquals(task.getText(), "Complete Activity with Google Keep");
		  if(i==3)
			  Assert.assertEquals(task.getText(), "Complete the second Activity Google Keep");
		  i--;
	  }
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}