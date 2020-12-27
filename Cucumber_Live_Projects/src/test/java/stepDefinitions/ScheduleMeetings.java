package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ScheduleMeetings extends Browser {    
	String subject;
	
    @Then("^Navigate to Schedule Meeting Page under Activities Meetings$")
    public void navigateToScheduleMeeting() {
    	driver.manage().window().maximize();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    									(By.xpath("//div[@id='toolbar']")));
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Activities']")));
    	driver.findElement(By.xpath("//a[text()='Activities']")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//a[text()='Meetings']")));
    	driver.findElement(By.xpath("//a[text()='Meetings']")).click();

    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Meetings')]")));
    	driver.findElement(By.xpath("//div[text()='Schedule Meeting']")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'CREATE')]")));
    }
    
    @And("^Add Meeting Details as follows$")
    public void addLeadInfo(DataTable table) {
    	List<List<String>> data = table.asLists();
    	
    	subject = data.get(0).get(1);
    	String duration = data.get(1).get(1);
    	String description = data.get(2).get(1);
    	
    	WebElement subjectInput = driver.findElement(By.id("name"));
    	WebElement durationInput = driver.findElement(By.id("duration"));
    	WebElement descriptionInput = driver.findElement(By.id("description"));
    	
    	Select durationDropdown = new Select(durationInput);
    	durationDropdown.selectByVisibleText(duration);
    	
    	subjectInput.sendKeys(subject);
    	descriptionInput.sendKeys(description);
    }
    
    @And("^Add invitees \"(.*)\",\"(.*)\",\"(.*)\" by searching$")
    public void addInvitees(String attendee1, String attendee2, String attendee3) {
    	driver.findElement(By.id("invitees_search")).click();	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//table[@class='list view']")));
    	
    	List<WebElement> rows = driver.findElements
    							(By.xpath("//table[@class='list view']/tbody/tr"));
    	
    	for(int i=1; i<rows.size(); i++) {
    		WebElement result = driver.findElement
        			(By.xpath("//table[@class='list view']/tbody/tr["+(i+1)+"]/td[2]"));
    		
    		if (result.getText().equals(attendee1)) {
    			driver.findElement(By.xpath
    			("//table[@class='list view']/tbody/tr["+(i+1)+"]/td[5]/input")).click();
    			continue;
    		}
    		if (result.getText().equals(attendee2)) {
    			driver.findElement(By.xpath
    			("//table[@class='list view']/tbody/tr["+(i+1)+"]/td[5]/input")).click();
    			continue;
    		}
    		if (result.getText().equals(attendee3)) {
    			driver.findElement(By.xpath
    			("//table[@class='list view']/tbody/tr["+(i+1)+"]/td[5]/input")).click();
    			break;
    		}
    	}
    }
    
    @And("^Save the Meeting$")
    public void saveMeeting() {
    	driver.findElement(By.id("SAVE_HEADER")).click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'"+subject+"')]")));
    }
    
    @And("^Navigate to View Meetings Page$")
    public void navigateToViewMeetings() {
    	driver.findElement(By.xpath("//div[text()='View Meetings']")).click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Meetings')]")));
    }
    
    @And("^Confirm the Meeting is Created with duartion \"(.*)\"$")
    public void confirmMeetingCreated(String duration) {
    	List<WebElement> rows = driver.findElements
    			(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
    	
    	for(int i=0; i<rows.size(); i++) {
    		WebElement result = driver.findElement
        			(By.xpath("//table[@class='list view table-responsive']"
        					+ "/tbody/tr["+(i+1)+"]/td[4]/b/a"));
    		
    		if (result.getText().equals(subject)) {
    			result.click();
    			wait.until(ExpectedConditions.visibilityOfElementLocated
    	    								(By.xpath("//h2[text()=' "+subject+" ']")));
    			break;
    		}
    	}
    	String meetingDuration = driver.findElement(By.id("duration")).getText();
    	Assert.assertEquals(duration,meetingDuration);
    }
}