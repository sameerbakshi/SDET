package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.training-support.net/selenium/nested-iframes");
        System.out.println("The Page Title is: "+driver.getTitle());
        
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
                
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());

        driver.switchTo().parentFrame();
        
        driver.switchTo().frame(1);
        
        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading2.getText());
               
        driver.close();
	}

}