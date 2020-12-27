package stepDefinitions;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;

public class AddCandidate extends Browser {  
    Random rand = new Random();
    int random = rand.nextInt();
    
    @And("^Add Candidate Information$")
    public void addCandidate() {
    	driver.findElement(By.id("btnAdd")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Add Candidate']")));
    	
    	WebElement firstNameInput = driver.findElement(By.id("addCandidate_firstName"));
    	WebElement lastNameInput = driver.findElement(By.id("addCandidate_lastName"));
    	WebElement emailInput = driver.findElement(By.id("addCandidate_email"));
    	
    	emailInput.sendKeys("User"+random+"@test.com");
    	firstNameInput.sendKeys("User");
    	lastNameInput.sendKeys(""+random);
    }
    
    @And("^Upload a Resume$")
    public void uploadResume() {
    	WebElement resume = driver.findElement(By.id("addCandidate_resume"));
    	resume.sendKeys("C:\\Users\\SameerBakshi\\Desktop\\Resume_SameerBakshi.pdf");
    }
    
    @And("^Save the Information$")
    public void saveInformation() { 	
    	driver.findElement(By.id("btnSave")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Candidate']")));
    }
    
    @And("^Navigate Back to Recruitments page$")
    public void navigateBackToRecruitments() {
    	driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Candidates']")));
    }
    
    @And("^Confirm Candidate Entry$")
    public void confirmCandidateEntry() {
    	driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("User "+random);
    	driver.findElement(By.id("btnSrch")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
    	
    	List<WebElement> rows = driver.findElements
    			(By.xpath("//table[@id='resultTable']/tbody/tr"));
    	
    	String candidate = "User "+random;
    	for(int i=0; i<rows.size(); i++) {
    		WebElement result = driver.findElement
        			(By.xpath("//table[@id='resultTable']/tbody/tr["+(i+1)+"]/td[3]/a"));
    		if (result.getText().equals(candidate)) {
    			result.click();
    			wait.until(ExpectedConditions.visibilityOfElementLocated
    	    			(By.xpath("//h1[text()='Candidate']")));
    			break;
    		}
    	}
    	String email = driver.findElement(By.id("addCandidate_email")).getAttribute("value");
    	Assert.assertEquals(email,"User"+random+"@test.com");
    }
}