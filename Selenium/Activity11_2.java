package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("The Page Title is: "+driver.getTitle());
        driver.findElement(By.cssSelector("button#confirm")).click();
        
        Alert confirmAlert = driver.switchTo().alert();
        
        String alertText = confirmAlert.getText();
        System.out.println("Alert text is: " + alertText);
        
        confirmAlert.accept();
        
        driver.findElement(By.cssSelector("button#confirm")).click();
        
        alertText = confirmAlert.getText();
        System.out.println("Alert text is: " + alertText);
        
        confirmAlert.dismiss();
        
        driver.close();
	}

}