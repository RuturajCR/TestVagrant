package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.Wiki;

public class BaseWiki {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\OneDrive\\Desktop\\Software Testing\\Selenium\\selenium files\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://www.google.com/");
	    
	    driver.manage().window().maximize();
	    
	    Wiki wi = new Wiki(driver);
	    
	    wi.search();
	    wi.src();
	    wi.clickwiki();
	    wi.releaseDate();
	    wi.getCountry();
	}

}
