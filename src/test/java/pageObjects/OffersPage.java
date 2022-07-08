package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By searchItem= By.xpath("//input[@id='search-field']");
	private By sameText= By.cssSelector("tr td:nth-child(1)");
	
	public void searchItems(String name) {
		driver.findElement(searchItem).sendKeys(name);
		
	}
	
	public String extractname() {
		return driver.findElement(sameText).getText();	
		}

}
