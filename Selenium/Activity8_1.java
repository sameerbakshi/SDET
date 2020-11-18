package selenium;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println("Page Title is:"+driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        WebElement toggleCheckboxButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        
        toggleCheckboxButton.click();
        
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        
        toggleCheckboxButton.click();
        
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
        
		driver.close();
	}

}