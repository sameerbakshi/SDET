package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateLeads extends Browser {    
	String name;
	
    @Then("^Navigate to Create Lead Page under Sales Leads$")
    public void navigateToCreateLeads() {
    	driver.manage().window().maximize();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    									(By.xpath("//div[@id='toolbar']")));
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sales']")));
    	driver.findElement(By.xpath("//a[text()='Sales']")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//a[text()='Leads']")));
    	driver.findElement(By.xpath("//a[text()='Leads']")).click();

    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Leads')]")));
    	driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'CREATE')]")));
    }
    
    @And("^Add Lead Information as follows$")
    public void addLeadInfo(DataTable table) {
    	List<List<String>> data = table.asLists();
    	
    	String firstName = data.get(0).get(1);
    	String lastName = data.get(1).get(1);
    	String email = data.get(2).get(1);
    	
    	name = firstName+" "+lastName;
    	
    	WebElement firstNameInput = driver.findElement(By.id("first_name"));
    	WebElement lastNameInput = driver.findElement(By.id("last_name"));
    	WebElement emailInput = driver.findElement(By.id("Leads0emailAddress0"));
    	
    	firstNameInput.sendKeys(firstName);
    	lastNameInput.sendKeys(lastName);
    	emailInput.sendKeys(email);
    }
    
    @And("^Save the Lead$")
    public void addLeadInfo() {
    	driver.findElement(By.id("SAVE")).click();	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'"+name+"')]")));
    }
    
    @And("^Navigate to View Leads Page$")
    public void navigateToViewLeads() {
    	driver.findElement(By.xpath("//div[text()='View Leads']")).click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Leads')]")));
    }
    
    @And("^See the Results$")
    public void seeLeadResults() {
    	List<WebElement> rows = driver.findElements
    			(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
    	
    	for(int i=0; i<rows.size(); i++) {
    		WebElement result = driver.findElement
        			(By.xpath("//table[@class='list view table-responsive']"
        					+ "/tbody/tr["+(i+1)+"]/td[3]/b/a"));
    		
    		if (result.getText().equals(name)) {
    			result.click();
    			wait.until(ExpectedConditions.visibilityOfElementLocated
    	    								(By.xpath("//h2[text()=' "+name+" ']")));
    			break;
    		}
    	}
    }
}