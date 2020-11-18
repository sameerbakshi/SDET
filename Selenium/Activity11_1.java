package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("The Page Title is: "+driver.getTitle());
        driver.findElement(By.cssSelector("button#simple")).click();
        
        Alert simpleAlert = driver.switchTo().alert();
        
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);
        
        simpleAlert.accept();
        
        driver.close();
	}

}