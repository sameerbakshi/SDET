package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println("Page Title is: "+driver.getTitle());
		
		WebElement inputText = driver.findElement(By.xpath("//div[@id='dynamicText']"));
		if (inputText.isEnabled())
			System.out.println("Input field is enabled");
		else
			System.out.println("Input field is not enabled");
		
		driver.findElement(By.xpath("//button[contains(@class,'blue button')]")).click();

		if (inputText.isEnabled())
			System.out.println("Input field is enabled");
		else
			System.out.println("Input field is not enabled");
		
		driver.close();
	}
	
}