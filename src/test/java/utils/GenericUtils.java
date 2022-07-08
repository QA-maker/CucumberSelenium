package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		
		this.driver=driver;
	}
	public void SwitchwindowToChild() {
		
		Set <String> s1= driver.getWindowHandles(); //recuento total de ventanass abiertas
     	Iterator <String> i1=s1.iterator(); //recupera las ventanas y empeiza a contar
     	String parentWindow = i1.next(); //ventana princuoal
     	String childWindow= i1.next(); //ventana secundaria
     	driver.switchTo().window(childWindow);
	}

}
