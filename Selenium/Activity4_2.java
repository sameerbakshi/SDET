package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println("Page Title is: "+driver.getTitle());
		
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\'firstName\']"));
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\'lastName\']"));
		firstName.sendKeys("Sameer");
        lastName.sendKeys("Bakshi");
 
        driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("test@example.com");
 
        driver.findElement(By.xpath("//*[@id=\'number\']")).sendKeys("1234567890");
 
        driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");
 
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        driver.switchTo().alert().accept();
        driver.close();
	}

}