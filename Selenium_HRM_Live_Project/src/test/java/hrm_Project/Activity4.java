package hrm_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity4 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	Random rand = new Random();
	int random = rand.nextInt(1000);
	
 @BeforeMethod
  public void beforeMethod() {
	//Launch the website
	driver.get("http://alchemy.hguy.co/orangehrm");
	//Fill in the login credentials
	WebElement username=driver.findElement(By.id("txtUsername"));
	WebElement password=driver.findElement(By.id("txtPassword"));
	username.sendKeys("orange");
	password.sendKeys("orangepassword123");
		  
	//Click on the login button
	driver.findElement(By.id("btnLogin")).click();
	}
 
  @Test
  public void testActivity4() {
	  //Wait for the PIM menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
	  	  
	  //Navigate to PIM page
	  driver.findElement(By.id("menu_pim_viewPimModule")).click();
	  driver.findElement(By.id("menu_pim_viewPimModule")).click();
	  
	  //Wait for the AddEmployee menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee")));
	  
	  /*
	  //Search if employee already exists with the name
	  driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Sameer Bakshi");
	  driver.findElement(By.id("searchBtn")).click();
	  
	  if(!driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td")).getText().contentEquals("No Records Found")) {
		  //Delete the existing user ids
		  driver.findElement(By.xpath("//table[@id='resultTable']/thead/tr/th/input")).click();
		  driver.findElement(By.id("btnDelete")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialogDeleteBtn")));
		  driver.findElement(By.id("dialogDeleteBtn")).click();
	  }
	  */
	  
	  //launch the addEmployee page
	  driver.findElement(By.id("menu_pim_addEmployee")).click();
	  
	  //Fill required employee details
	  driver.findElement(By.id("firstName")).sendKeys("Sameer");
	  driver.findElement(By.id("lastName")).sendKeys("Bakshi");
	  
	  WebElement checkbox= driver.findElement(By.id("chkLogin"));
	  
	  if (!checkbox.isSelected())
		  checkbox.click();
	  
	  driver.findElement(By.id("user_name")).sendKeys("sameerorange"+random);
	  driver.findElement(By.id("user_password")).sendKeys("orangepassword123");
	  driver.findElement(By.id("re_password")).sendKeys("orangepassword123");
	  
	  WebElement statuscheckbox=driver.findElement(By.id("status"));
	  
	  Select dropdown=new Select(statuscheckbox);
	  
	  dropdown.selectByValue("Enabled");
	  
	  //Click on the save button
	  driver.findElement(By.id("btnSave")).click();
	  
	  //Wait for the AddEmployee menu
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='personalDetails']")));
	  
	  //Navigate to admin page
	  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  
	  //Wait for the admin landing page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchSystemUser_userName")));
	  
	  //Set the username and click on search button
	  driver.findElement(By.id("searchSystemUser_userName")).sendKeys("sameerorange"+random);
	  driver.findElement(By.id("searchBtn")).click();
	  
	  //Validate that the Employee profile has been added 
	  WebElement name=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]"));
	  
	  Assert.assertEquals(name.getText(),"Sameer Bakshi");
	  Reporter.log("Employee profile successfully created");
      } 
	
  @AfterMethod
  public void afterMethod() {
	  //Close the driver
	  driver.close();
  }

}