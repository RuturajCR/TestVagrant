package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.Imdb;

public class BaseImdb {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\OneDrive\\Desktop\\Software Testing\\Selenium\\selenium files\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://www.google.com/");
	    
	    driver.manage().window().maximize();
	    
	    Imdb ib= new Imdb(driver);
	   ib.srchtitle();
	   ib.imdb();
	   ib.src();
	   ib.ent();
	   ib.releaseDate();
	}
	

}
