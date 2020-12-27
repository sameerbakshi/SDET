package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PostJob extends Browser{    
    @When("^User navigates to Post a Job page$")
    public void navigateToPostJobPage() {
    	WebElement postJobURL = driver.findElement(By.xpath("//a[text()='Post a Job']"));
    	postJobURL.click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h1[text()='Post a Job']")));
    }
    
    @Then("^Fill in the following Job Information details$")
    public void fillDetails(DataTable table) {
    	List<List<String>> data = table.asLists();
    	WebElement email = driver.findElement(By.xpath("//input[@id='create_account_email']"));
    	WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job_title']"));
    	WebElement jobType = driver.findElement(By.xpath("//select[@id='job_type']"));
    	WebElement appURL = driver.findElement(By.xpath("//input[@id='application']"));
    	WebElement company = driver.findElement(By.xpath("//input[@id='company_name']"));
    	
    	Select jobTypeDropdown = new Select(jobType);
    	
    	email.sendKeys(data.get(0).get(1));
    	jobTitle.sendKeys(data.get(1).get(1));
    	jobTypeDropdown.selectByVisibleText(data.get(2).get(1));
    	driver.switchTo().frame(0);
    	driver.findElement(By.xpath("//body")).sendKeys(data.get(3).get(1));
    	driver.switchTo().defaultContent();
    	appURL.sendKeys(data.get(4).get(1));
    	company.sendKeys(data.get(5).get(1));
    }
    
    @And("^Submit the Job$")
    public void submitJob() {
    	driver.findElement(By.xpath("//input[@value='Preview']")).click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[text()='Preview']")));
    	
    	driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//div[contains(text(),'Job listed')]")));
    }
   	
    @And("^Go To Jobs Page$")
    public void goToJobsPage() {
    	driver.findElement(By.xpath("//a[text()='Jobs']")).click();  	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h1[text()='Jobs']")));
    }
    
    @And("^Search for the Submitted Job \"(.*)\"$")
    public void searchJobListing(String job) {    	
    	driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys(job);
    	driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h3[text()='"+job+"']")));
    }
    
    @And("^Confirm the \"(.*)\" Job is present$")
    public void confirmJobPresent(String job) {
    	driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h1[contains(text(),'"+job+"')]")));
    }
}