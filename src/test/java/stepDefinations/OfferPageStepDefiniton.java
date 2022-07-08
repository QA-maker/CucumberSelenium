package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;


public class OfferPageStepDefiniton {
	String offerPage;
	
	
	public WebDriver driver;
	TestContextSetup testcontextsetup;
	PageObjectManager pageObjectManager;
	
	//Single responability Principle	
	public OfferPageStepDefiniton (TestContextSetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
	}
	    
	    @Then("user search for {string} shortname in offers page")
	    public void user_search_for_something_shortname_in_offers_page(String shortName) 
	    		throws Throwable {
	       
	    	Thread.sleep(5000);
	    	
	    	switchToOffersPage();
	    	pageObjectManager= new PageObjectManager(testcontextsetup.driver);
	    	OffersPage offerPage=pageObjectManager.getOffersPage();
	    	
	    	offerPage.searchItems(shortName);
	    	offerPage.extractname();
	    	String getofferPage = offerPage.extractname();
	     	Thread.sleep(3000);
	     	
	     	System.out.println(offerPage + "\t Contains same Text");
	     			     	
	     	
	    }
	    
	    public void switchToOffersPage() {
	    	//if switched to offer page -->skip below part
	    	//pageObjectManager= new PageObjectManager(testcontextsetup.driver);
	    	LandingPage landingpage=testcontextsetup.pageObjectManager.getLandingPage();
	    	landingpage.selectTopDeals();
	    	testcontextsetup.genericUtils.SwitchwindowToChild();
	     
	    	
	    }
	    
	   
		@Then("Validate product name in offers page matches with Landing Page") 
	    	
	    public void validate_product_name_in_offers_page() {
	    		
	    		Assert.assertEquals(offerPage,testcontextsetup.landinPageproductName);
	    	}
	    	
	    	 
}
