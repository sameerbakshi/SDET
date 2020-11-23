package hrm_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;


public class Activity9 {
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
  	public void testActivity9() {
  	 //Wait for menu to load
  	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
  	 
  	 //Navigate to the “My Info” page.
	 actions.moveToElement(driver.findElement(By.id("menu_pim_viewMyDetails"))).click().perform();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Personal Details')]")));
	
	 //Click on the “Emergency Contacts” menu item	 
	 driver.findElement(By.xpath("//a[contains(@href,'EmergencyContacts')]")).click();
	   
	 //Retrieve information about all the contacts listed in the table
	 List<WebElement> tableRows = driver.findElements(By.xpath("//table[contains(@class, 'table')]/tbody/tr"));
		//Calculate no of rows in the table
		int rows_count = tableRows.size();
		Reporter.log("There are "+rows_count+" emergency contacts listed.\n");
		    	
		//Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {
		   //Locate columns(cells) of a specific row
		   List <WebElement> tableCells = tableRows.get(row).findElements(By.tagName("td"));
		   //Calculate no of columns in that specific row
		   int columns_count = tableCells.size();
		   
		   //Print row details to the console
		   Reporter.log("Contact "+(row+1)+" details are:");
		   //Loop will execute till the last cell of the row
		   for (int cell = 0; cell < columns_count; cell++) {
		    	// Retrieve text from each cell
		    	String celtext = tableCells.get(cell).getText();
		    	Reporter.log(celtext+"\t");
		    	}
		   Reporter.log("\n-------------------------------------------------- ");
		   }
  }

  @AfterClass
  public void afterClass() {
	  //Close the driver
	  driver.close();
  }

}