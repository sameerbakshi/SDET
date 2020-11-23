package hrm_Project;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
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
	public void testActivity7(){
		//Wait for menu to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
  
		//Navigate to the “My Info” page.
		actions.doubleClick(driver.findElement(By.id("menu_pim_viewMyDetails"))).perform();

		//Select qualifications option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'Qualifications')]")));
		driver.findElement(By.xpath("//a[contains(@href,'Qualifications')]")).click();
	
		//Add work exp
		driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
        
        //Adding dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Date fromDate = new Date();	  
    	Date toDate = new Date();
        driver.findElement(By.id("experience_from_date")).click();
        driver.findElement(By.id("experience_from_date")).sendKeys(dateFormat.format(fromDate));
        driver.findElement(By.id("experience_from_date")).sendKeys(Keys.TAB);
        
        driver.findElement(By.id("experience_to_date")).click();
        driver.findElement(By.id("experience_to_date")).sendKeys(dateFormat.format(toDate));
        driver.findElement(By.id("experience_to_date")).sendKeys(Keys.TAB);
        
        //Add comment
        driver.findElement(By.id("experience_comments")).sendKeys("comment for test");
       
        //Save the details
        driver.findElement(By.id("btnWorkExpSave")).click();
	}
	
	@AfterClass
	public void afterClass() {
		//Close the driver
		driver.close();
	}
	
}