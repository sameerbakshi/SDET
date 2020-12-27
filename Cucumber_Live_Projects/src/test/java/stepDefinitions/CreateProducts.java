package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateProducts extends Browser {    
	String product;
	
    @Then("^Navigate to Create Product Page under All Products$")
    public void navigateToCreateProduct() {
    	driver.manage().window().maximize();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    									(By.xpath("//div[@id='toolbar']")));
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='All']")));
    	driver.findElement(By.xpath("//a[text()='All']")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//a[text()='Products']")));
    	driver.findElement(By.xpath("//a[text()='Products']")).click();

    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Products')]")));
    	driver.findElement(By.xpath("//div[text()='Create Product']")).click();
    	
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'CREATE')]")));
    }
    
    @And("^Enter Product details as follows$")
    public void enterProductDetails(DataTable table) {
    	List<List<String>> data = table.asLists();
    	
    	product = data.get(0).get(1);
    	String price = data.get(1).get(1);
    	String description = data.get(2).get(1);
    	
    	WebElement productInput = driver.findElement(By.id("name"));
    	WebElement priceInput = driver.findElement(By.id("price"));
    	WebElement descriptionInput = driver.findElement(By.id("description"));
    	
    	productInput.sendKeys(product);
    	priceInput.sendKeys(price);
    	descriptionInput.sendKeys(description);
    }
 
    @And("^Save the Product$")
    public void saveProduct() {
    	driver.findElement(By.id("SAVE")).click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'"+product+"')]")));
    }
    
    @And("^Go to View Products Page$")
    public void navigateToViewProducts() {
    	driver.findElement(By.xpath("//div[text()='View Products']")).click();
    	wait.until(ExpectedConditions.
    			visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Products')]")));
    }
    
    @And("^See all the Products listed on the Page$")
    public void seeListedProducts() {
    	List<WebElement> products = driver.findElements
    			(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
    	
    	System.out.println("Number of products listed on this page is: "+products.size());
    }
}