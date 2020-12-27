package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CountDashlets extends Browser {   
	List<WebElement> dashlets;
	
    @Given("^User is on CRM Login Page$")
    public void navigateToCRMLogin(){
    	driver = new FirefoxDriver();
    	wait = new WebDriverWait(driver,10);
    	
    	driver.get("http://alchemy.hguy.co/crm/");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
    }
    
    @When("^User logs in to CRM with username \"(.*)\" and password \"(.*)\"")
    public void loginToCRM(String username, String password) {
    	WebElement usernameInput = driver.findElement(By.id("user_name"));
    	WebElement passwordInput = driver.findElement(By.id("username_password"));
    	WebElement loginButton = driver.findElement(By.id("bigbutton"));
    	
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    	loginButton.click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//div[@id='toolbar']")));
    }
    
    @Then("^Count the Dashlets$")
    public void countDashlets() {
    	driver.manage().window().maximize();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//table[@class='dashletTable']")));
    	
    	dashlets = driver.findElements
    			(By.xpath("//td[@class='dashlet-title']"));
    	System.out.println("Total number of dashlets present is: "+dashlets.size());
    }
    
    @And("^Print the title of each dashlet$")
    public void printDashletTitles() {
    	System.out.println("Titles of dashlets are:");
    	for(WebElement dashlet:dashlets) {
    		System.out.println(dashlet.getText());
    	}
    }
}