package hrm_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	WebDriver driver = new FirefoxDriver();
	  @BeforeMethod
	  public void beforeMethod() {
		  //Initialize driver and get the url
		  driver = new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
		  }  
	  	
  @Test
  public void testActivity2() {
	  //Print the title
	  String title = driver.getTitle();
	  Reporter.log("Title is: " + title);
      //Print the url of image
	  WebElement imgurl = driver.findElement(By.xpath("//img[@src=\"/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png\"]"));
	  Reporter.log(" url of the header image is" +  imgurl.getAttribute("src"));
  }

  @AfterMethod
  public void afterMethod() {
	  //Close the driver
	  driver.close();
  }

}