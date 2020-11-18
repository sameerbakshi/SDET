package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/");
		System.out.println("Page Title is: "+driver.getTitle());
		
		WebElement aboutUsLink = driver.findElement(By.xpath("//*[@id=\'about-link\']"));
		aboutUsLink.click();
		System.out.println("New Page Title is: "+driver.getTitle());
		
		driver.close();
	}

}
