package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println("Page Title is: "+driver.getTitle());
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@name='toggled']"));
		if (checkBox.isSelected())
			System.out.println("Checkbox is selected");
		else
			System.out.println("Checkbox is not selected");
		
		checkBox.click();
		if (checkBox.isSelected())
			System.out.println("Checkbox is selected");
		else
			System.out.println("Checkbox is not selected");
		
		driver.close();
	}
	
}