package stepDefinations;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup textContextSetup;
	
	public Hooks (TestContextSetup textContextSetup) {
		
		this.textContextSetup=textContextSetup;
	}
	
	@After
	public void afterScenario() throws IOException
	{
		textContextSetup.testBase.WebDriverManager().quit();
		
	}

}
