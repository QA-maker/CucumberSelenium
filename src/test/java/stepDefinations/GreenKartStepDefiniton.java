package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GreenKartStepDefiniton {
	public WebDriver driver;
	 @Given("^User is on GreenCart Landing page$")
	    public void user_is_on_greencart_landing_page() throws Throwable {
	       System.setProperty("webdriver.chrome.driver","src/terst/resources/chromedriverV102.exe");
		  driver= new ChromeDriver ();
				 driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
				 
	    }

	    @When("^user searched with Shortname \"([^\"]*)\" abnd extract actual name of prodcut$")
	    public void user_searched_with_shortname_something_abnd_extract_actual_name_of_prodcut(String shortName) throws Throwable {
	        
	    	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    	String landinPageproductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	    	System.out.println(landinPageproductName + "is extracted from home page");
	    	}

	    @Then("^user search for \"([^\"]*)\" shortname in offers page to check if product exist with same name$")
	    public void user_search_for_something_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String shortName) throws Throwable {
	       
	    
	     	driver.findElement(By.linkText("Top Deals")).click();
	     	Set <String> s1= driver.getWindowHandles();
	     	Iterator <String> i1=s1.iterator();
	     	String parentWindow = i1.next();
	     	String childWindow= i1.next();
	     	
	     	driver.switchTo().window(childWindow);
	     	driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	     	String offerPage=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	     	
	     	System.out.println(offerPage + "Contains same Text");
	     			     	
	     	
	    }
}
