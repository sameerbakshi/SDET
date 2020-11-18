package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println("Page Title is: "+driver.getTitle());
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@name='toggled']"));
		if (checkBox.isDisplayed())
			System.out.println("Checkbox is displayed");
		else
			System.out.println("Checkbox is not displayed");
		
		driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
		
		if (checkBox.isDisplayed())
			System.out.println("Checkbox is displayed");
		else
			System.out.println("Checkbox is not displayed");
		
		driver.close();
	}

}