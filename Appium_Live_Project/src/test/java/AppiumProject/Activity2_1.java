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
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity2_1 {
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
  }

  @Test
  public void toDoList(){
	  //Click on To Do List card
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("UiScrollable(UiSelector().scrollable(true))."
			  		+ "scrollIntoView(textContains(\"To-Do List\"))")).click();
	  
	  wait.until(ExpectedConditions.visibilityOf
    		  (driver.findElementByXPath("//android.widget.TextView[@text='To-Do List']")));
	  
	  String[] tasks = {"Add tasks to list","Get number of tasks","Clear the list"};
	  //Add first task
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"taskInput\")")).sendKeys(tasks[0]);
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	  
	  //Add second task
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"taskInput\")")).sendKeys(tasks[1]);
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	  
	  //Add third task
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"taskInput\")")).sendKeys(tasks[2]);
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	  
	  List<MobileElement> tasksList = driver.findElements(MobileBy.xpath
			  ("//android.view.View[@resource-id='tasksList']/android.view.View"));
	  Assert.assertEquals(tasksList.size(),4);
	  Assert.assertEquals(tasksList.get(0).getText(),"Add more tasks to this list.");
	  Assert.assertEquals(tasksList.get(1).getText(), tasks[0]);
	  Assert.assertEquals(tasksList.get(2).getText(), tasks[1]);
	  Assert.assertEquals(tasksList.get(3).getText(), tasks[2]);
	  Reporter.log("3 tasks added to list");
	  
	  //Click on the tasks to strike them out
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\""+tasks[0]+"\")")).click();
	  Reporter.log("First task striked out");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\""+tasks[1]+"\")")).click();
	  Reporter.log("Second task striked out");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\""+tasks[2]+"\")")).click();
	  Reporter.log("Third task striked out");
	  
	  //Clear the list
	  driver.findElement(MobileBy.xpath
			  ("//android.view.View[@resource-id='tasksCard']/android.view.View[3]")).click();
	  Reporter.log("List cleared");
	  
	  //Adding another task to assert
	  driver.findElement(MobileBy.AndroidUIAutomator
			  ("resourceId(\"taskInput\")")).sendKeys("Tasks Completed");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	  
	  List<MobileElement> task = driver.findElements(MobileBy.xpath
			  ("//android.view.View[@resource-id='tasksList']/android.view.View"));
	  Assert.assertEquals(task.size(),1);
	  Assert.assertEquals(task.get(0).getText(),"Tasks Completed");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}