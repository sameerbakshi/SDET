package hrm_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	Random rand = new Random();
	int random = rand.nextInt(10000);  
	Actions actions = new Actions(driver);
	
  @BeforeClass
  public void beforeClass() {
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
  public void testActivity5() {
	  //Wait for menu to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));

	  //Click on MyInfo
	  WebElement myInfo=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails"));
	  actions.doubleClick(myInfo).perform();
	  
	  //Wait for personal details tab to be visible
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'PersonalDetails')]")));
	  
	  //Navigate to the personal details page
	  driver.findElement(By.xpath("//a[contains(@href,'viewPersonalDetails')]")).click();
	  
	  //Click the Edit button
	  driver.findElement(By.id("btnSave")).click();
	  
	  //Fill in Name
	  
	  driver.findElement(By.id("personal_txtEmpFirstName")).clear();
	  driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Test"+random);
	  driver.findElement(By.id("personal_txtEmpLastName")).clear();
	  driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Name"+random);
	  
	  //Fill in Gender
	  driver.findElement(By.id("personal_optGender_1")).click();
	  
	  //Fill in Nationality
	  
	  WebElement nationality=driver.findElement(By.id("personal_cmbNation"));
	  Select dropdown=new Select(nationality);
	  dropdown.selectByVisibleText("Indian");  
	  
	  //Fill in DOB
	  driver.findElement(By.id("personal_DOB")).clear();
	  driver.findElement(By.id("personal_DOB")).sendKeys("1985-01-01");
	  
	//Click the Save button
	  driver.findElement(By.id("btnSave")).click();
	  	  
  }

  @AfterClass
  public void afterClass() {
	  //Close the driver
	  driver.close();
  }

}