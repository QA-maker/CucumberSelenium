package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;








public class LandingPageStepDefiniton {
	
	public String offerPage;
	public String landinPageproductName;
	public WebDriver driver;
	TestContextSetup testcontextsetup;
	PageObjectManager pageObjectManager;
//Single responability Principle	
	public LandingPageStepDefiniton(TestContextSetup testcontextsetup) {
		
		this.testcontextsetup=testcontextsetup;
	}
	
	 @Given("User is on GreenCart Landing page")
	    public void user_is_on_greencart_landing_page() throws Throwable {
	    
				 
	    }

	    @When("user searched with Shortname {string} abnd extract actual name of prodcut")
	    public void user_searched_with_shortname_something_abnd_extract_actual_name_of_prodcut(String shortName) throws Throwable {
	    	Thread.sleep(100000);
	    	LandingPage landinPage= new LandingPage(testcontextsetup.driver);
	    	landinPage.searchItem(shortName);
	    	Thread.sleep(100000);
	    	testcontextsetup.landinPageproductName=landinPage.getProductName().split("-")[0].trim();
	    	
	    	
	    	System.out.println(testcontextsetup.landinPageproductName + " '\t is extracted from home page");
	    	}

	    
	    	 
}
