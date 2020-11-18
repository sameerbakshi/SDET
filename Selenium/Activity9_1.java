package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println("Page Title is: "+driver.getTitle());
		
		WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'password')]"));
        
        userName.sendKeys("admin");
        password.sendKeys("password");
        
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);
        
		driver.close();
	}

}