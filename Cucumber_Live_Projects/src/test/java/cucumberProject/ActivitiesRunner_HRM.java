package cucumberProject;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@hrm",
    plugin = {"html:HRM.html"},
    monochrome = true
)
public class ActivitiesRunner_HRM {
	
}