package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@CucumberOptions(features="src/test/java/features", glue="stepDefinations",
monochrome=true, dryRun=true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	

}
