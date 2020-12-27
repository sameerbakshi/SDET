package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchJob extends Browser{
    @Given("^User is on Job Board Home Page$")
    public void navigateToJobBoardHome(){
    	driver = new FirefoxDriver();
    	wait = new WebDriverWait(driver,10);
    	
    	driver.get("https://alchemy.hguy.co/jobs");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("site-title")));
    }
    
    @When("^User navigates to Jobs page$")
    public void navigateToJobsPage() {
    	WebElement jobsURL = driver.findElement(By.xpath("//a[text()='Jobs']"));
    	jobsURL.click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h1[text()='Jobs']")));
    }
    
    @Then("^Enter Keywords in the input field$")
    public void enterKeywords() {
    	driver.manage().window().maximize();
    	WebElement keyWords = driver.findElement(By.xpath("//input[@id='search_keywords']"));
    	keyWords.sendKeys("Selenium");
    }
    
    @And("^Search for Jobs with the Keywords$")
    public void searchJobs() {
    	driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
    }
   	
    @And("^Filter Job Type to show only Full Time jobs$")
    public void filterJobType() {
    	WebElement checkBoxFullTime = driver.findElement
    			(By.xpath("//input[@id='job_type_full-time']"));
    	if(!checkBoxFullTime.isSelected()) {
    		checkBoxFullTime.click();
    	}
    	
    	WebElement checkBoxFreelance = driver.findElement
    			(By.xpath("//input[@id='job_type_freelance']"));
    	WebElement checkBoxInternship = driver.findElement
    			(By.xpath("//input[@id='job_type_internship']"));
    	WebElement checkBoxPartTime = driver.findElement
    			(By.xpath("//input[@id='job_type_part-time']"));
    	WebElement checkBoxTemporary = driver.findElement
    			(By.xpath("//input[@id='job_type_temporary']"));
    	
    	if(checkBoxFreelance.isSelected()) {
    		checkBoxFreelance.click();    		
    	}
    	if(checkBoxInternship.isSelected()) {
    		checkBoxInternship.click();
    	}
    	if(checkBoxPartTime.isSelected()) {
    		checkBoxPartTime.click();
    	}
    	if(checkBoxTemporary.isSelected()) {
    		checkBoxTemporary.click();
    	}
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//ul[@class='job_listings']/li[1]/a")));
    }
    
    @And("^Click on a Job Listing$")
    public void clickJobListing() {
    	WebElement jobListing = driver.findElement
    			(By.xpath("//ul[@class='job_listings']/li[1]/a"));
    	jobListing.click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Automation')]")));
    }
    
    @And("^Print the Job Listing Title$")
    public void printJobTitle() {
    	WebElement jobTitle = driver.findElement(By.xpath("//h1[@class='entry-title']"));
    	System.out.println("Title of Job Listing is: "+jobTitle.getText());
    }
    
    @And("^Click on Apply for job button$")
    public void applyForJob() {
    	WebElement applyJobButton = driver.findElement
				((By.xpath("//input[@class='application_button button']")));
    	applyJobButton.click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.className("job_application_email")));
    	
    	System.out.println(driver.findElement
    			(By.className("job_application_email")).getText());
    }
}