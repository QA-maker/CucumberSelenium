package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	
	public WebDriver driver;
	
	
	public WebDriver  WebDriverManager() throws IOException {
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String url =prop.getProperty("QAUrl");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("start-maximized");
		if(driver==null) {
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {//cuando eldriver no esta cargado
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
	       driver= new ChromeDriver (options);
	       
	       
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			//firefox code
		}
		
		driver.get(url);
	}
		return driver;
}	
			
	
	
}
