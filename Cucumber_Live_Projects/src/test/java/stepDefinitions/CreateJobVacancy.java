package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateJobVacancy extends Browser {   
    @Given("^User is on HRM Login Page$")
    public void navigateToHRMLogin(){
    	driver = new FirefoxDriver();
    	wait = new WebDriverWait(driver,10);
    	
    	driver.get("http://alchemy.hguy.co/orangehrm");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
    }
    
    @When("^User logs in to HRM with \"(.*)\" and \"(.*)\"")
    public void loginToHRM(String username, String password) {
    	WebElement usernameInput = driver.findElement(By.id("txtUsername"));
    	WebElement passwordInput = driver.findElement(By.id("txtPassword"));
    	WebElement loginButton = driver.findElement(By.id("btnLogin"));
    	
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    	loginButton.click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
    }
    
    @Then("^Navigate to Recruitment page$")
    public void navigateToRecruitment() {
    	driver.manage().window().maximize();
    	wait.until(ExpectedConditions.elementToBeClickable
    			(driver.findElement(By.xpath("//b[text()='Recruitment']"))));
    	
    	driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Candidates']")));
    }
    
    @And("^Navigate to Vacancies page$")
    public void navigateToVacancies() {
    	driver.findElement(By.xpath("//a[text()='Vacancies']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Vacancies']")));
    }
    
    @And("^Open Add Job Vacancy Form$")
    public void openAddVacancyForm() {
    	driver.findElement(By.id("btnAdd")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Add Job Vacancy']")));
    }
    
    @And("^Enter details as follows$")
    public void enterDetails(DataTable table) {
    	List<List<String>> data = table.asLists();
    	
    	WebElement jobTitle = driver.findElement(By.id("addJobVacancy_jobTitle"));
    	Select jobTitleDropdown = new Select(jobTitle);
    	jobTitleDropdown.selectByVisibleText(data.get(0).get(1));
    	
    	WebElement vacancyName = driver.findElement(By.id("addJobVacancy_name"));
    	WebElement hiringManager = driver.findElement
    			(By.xpath("//input[@id='addJobVacancy_hiringManager']"));
   	
    	vacancyName.sendKeys(data.get(1).get(1));
    	hiringManager.sendKeys(data.get(2).get(1));
    }
    
    @And("^Save the Vacancy$")
    public void saveVacancy() {
    	driver.findElement(By.id("btnSave")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Edit Job Vacancy']")));
    }
    
    @And("^Verify \"(.*)\" Vacancy was created$")
    public void verifyVacancyCreated(String vacancyName) {
    	driver.findElement(By.id("btnBack")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Vacancies']")));
    	
    	WebElement vacancySearch = driver.findElement(By.id("vacancySearch_jobVacancy"));
    	Select vacancySearchDropdown = new Select(vacancySearch);
    	vacancySearchDropdown.selectByVisibleText(vacancyName);
    	
    	driver.findElement(By.id("btnSrch")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
    	
    	String vacancy = driver.findElement
    			(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).getText();
    	Assert.assertEquals(vacancy,vacancyName);
    	
    	driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Edit Job Vacancy']")));
    }
}