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


public class OfferPageStepDefiniton {
	public String landinPageproductName;
	public String offerPage;
	public WebDriver driver;
	
	    
	    @Then("user search for {string} shortname in offers page")
	    public void user_search_for_something_shortname_in_offers_page(String shortName) 
	    		throws Throwable {
	       
	    
	     	driver.findElement(By.linkText("Top Deals")).click();
	     	Set <String> s1= driver.getWindowHandles(); //recuento total de ventanass abiertas
	     	Iterator <String> i1=s1.iterator(); //recupera las ventanas y empeiza a contar
	     	String parentWindow = i1.next(); //ventana princuoal
	     	String childWindow= i1.next(); //ventana secundaria
	     	
	     	driver.switchTo().window(childWindow);
	     	driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	     	Thread.sleep(3000);
	     	 offerPage=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	     	
	     	System.out.println(offerPage + "\t Contains same Text");
	     			     	
	     	
	    }
	    
	   
		@Then("Validate product name in offers page matches with Landing Page") 
	    	
	    public void validate_product_name_in_offers_page() {
	    		
	    		Assert.assertEquals(offerPage,landinPageproductName);
	    	}
	    	
	    	 
}
