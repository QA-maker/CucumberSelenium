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
import utils.TestContextSetup;


public class OfferPageStepDefiniton {
	String offerPage;
	
	
	public WebDriver driver;
	TestContextSetup testcontextsetup;
	//Single responability Principle	
	public OfferPageStepDefiniton (TestContextSetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
	}
	    
	    @Then("user search for {string} shortname in offers page")
	    public void user_search_for_something_shortname_in_offers_page(String shortName) 
	    		throws Throwable {
	       
	    	Thread.sleep(10000);
	    	
	    	switchToOffersPage();
	    	OffersPage offerPages= new OffersPage(testcontextsetup.driver);
	    	offerPages.searchItems(shortName);
	    	offerPage=offerPages.extractname();
	     	Thread.sleep(3000);
	     	
	     	System.out.println(offerPages + "\t Contains same Text");
	     			     	
	     	
	    }
	    
	    public void switchToOffersPage() {
	    	//if switched to offer page -->skip below part
	    	LandingPage landingpage=new LandingPage(testcontextsetup.driver);
	    	landingpage.selectTopDeals();
	     	Set <String> s1= driver.getWindowHandles(); //recuento total de ventanass abiertas
	     	Iterator <String> i1=s1.iterator(); //recupera las ventanas y empeiza a contar
	     	String parentWindow = i1.next(); //ventana princuoal
	     	String childWindow= i1.next(); //ventana secundaria
	     	testcontextsetup.driver.switchTo().window(childWindow);
	    	
	    }
	    
	   
		@Then("Validate product name in offers page matches with Landing Page") 
	    	
	    public void validate_product_name_in_offers_page() {
	    		
	    		Assert.assertEquals(offerPage,testcontextsetup.landinPageproductName);
	    	}
	    	
	    	 
}
