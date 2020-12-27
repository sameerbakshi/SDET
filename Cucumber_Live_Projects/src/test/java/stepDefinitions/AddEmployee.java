package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddEmployee extends Browser {
	@Then("^Navigate to PIM page$")
	public void navigateToPIM() {
		driver.manage().window().maximize();
    	wait.until(ExpectedConditions.elementToBeClickable
    			(driver.findElement(By.xpath("//b[text()='PIM']"))));
    	
    	driver.findElement(By.xpath("//b[text()='PIM']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Employee Information']")));
	}
	
	@And("^Add New Employee$")
	public void addNewEmployee() {
		driver.findElement(By.id("btnAdd")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Add Employee']")));
	}
	
	@And("^Check Login Details$")
	public void checkLoginDetails() {
		if(!driver.findElement(By.id("chkLogin")).isSelected()) {
			driver.findElement(By.id("chkLogin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
		}
	}
	
    @And("^Enter Employees Details as follows$")
    public void enterEmployeeDetails(DataTable table) {   
    	List<List<String>> data = table.asLists();
    	String firstName = data.get(0).get(1);
    	String lastName = data.get(1).get(1);
    	String userName = data.get(2).get(1);
    	
    	WebElement firstNameInput = driver.findElement(By.id("firstName"));
    	WebElement lastNameInput = driver.findElement(By.id("lastName"));
    	WebElement userNameInput = driver.findElement(By.id("user_name"));
    	
    	firstNameInput.sendKeys(firstName);
    	lastNameInput.sendKeys(lastName);
    	userNameInput.sendKeys(userName);
    }
    
    @And("^Save the New Employee$")
    public void saveEmployee() {
    	driver.findElement(By.id("btnSave")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Personal Details']")));
    }
    
    @And("^Verify \"(.*)\" \"(.*)\" employee has been created$")
    public void verifyEmployeeCreated(String firstName, String lastName) {
    	wait.until(ExpectedConditions.elementToBeClickable
    			(driver.findElement(By.xpath("//b[text()='PIM']"))));
    	
    	driver.findElement(By.xpath("//b[text()='PIM']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Employee Information']")));
    	
    	driver.findElement(By.id("empsearch_employee_name_empName"))
    							.sendKeys(firstName+" "+lastName);
    	driver.findElement(By.id("searchBtn")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
    	
    	String first = driver.findElement
    			(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]/a")).getText();
    	String last = driver.findElement
    			(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]/a")).getText();
    	
    	Assert.assertEquals(first,firstName);
    	Assert.assertEquals(last,lastName);
    	
    	driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//h1[text()='Personal Details']")));
    }
}