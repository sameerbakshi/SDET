package stepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateJobBoardUser extends Browser {
    WebDriverWait wait;
    Random rand = new Random();
    int random = rand.nextInt();
    
    @Given("^User is on Job Board Login Page$")
    public void navigateToJobBoardLogin(){
    	wait = new WebDriverWait(driver,5);
    	
    	driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
    }
    
    @When("^User logs in to Job Board system with \"(.*)\" and \"(.*)\"")
    public void loginToJobBoard(String username, String password) {
    	WebElement usernameInput = driver.findElement(By.id("user_login"));
    	WebElement passwordInput = driver.findElement(By.id("user_pass"));
    	WebElement loginButton = driver.findElement(By.id("wp-submit"));
    	
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    	loginButton.click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
    }
    
    @Then("^Choose Users option from menu$")
    public void addNewJobBoardUser() {
    	driver.manage().window().maximize();
    	wait.until(ExpectedConditions.elementToBeClickable
    			(driver.findElement(By.xpath("//div[text()='Users']"))));
    	driver.findElement(By.xpath("//div[text()='Users']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[contains(text(),'Users')]")));
    }
    
    @And("^Navigate to Add New User page$")
    public void navigateToAddNewUser() {
    	driver.findElement(By.className("page-title-action")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[contains(text(),'Add New User')]")));
    }
    
    @And("^Fill the details$")
    public void createNewJobBoardUser() {
    	WebElement newUsernameInput = driver.findElement(By.id("user_login"));
    	WebElement emailInput = driver.findElement(By.id("email"));
    	WebElement firstNameInput = driver.findElement(By.id("first_name"));
    	WebElement lastNameInput = driver.findElement(By.id("last_name"));
   	
    	newUsernameInput.sendKeys("User"+random);
    	emailInput.sendKeys("User"+random+"@test.com");
    	firstNameInput.sendKeys("User");
    	lastNameInput.sendKeys(""+random);
    }
    
    @And("^Add new Job Board user$")
    public void createAddJobBoardUser() {
    	WebElement addUserButton = driver.findElement(By.id("createusersub"));
    	addUserButton.click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//p[contains(text(),'New user created.')]")));
    }
    
    @And("^Verify new Job Board user is created$")
    public void verifyNewJobBoardUser() {
    	String newUserText = driver.findElement
				((By.xpath("//p[contains(text(),'New user created.')]"))).getText();
    	Assert.assertEquals(newUserText, "New user created. Edit user");
    }
}