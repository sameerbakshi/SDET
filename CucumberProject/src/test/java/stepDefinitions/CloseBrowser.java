package stepDefinitions;

import io.cucumber.java.en.And;

public class CloseBrowser extends Browser{
	@And("^Close the browser$")
	public void closeBrowser() {	
	driver.quit();
	}
}