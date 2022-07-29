package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.Imdb;

public class TestNGImdb {
	
	WebDriver driver;
	Imdb imdb;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("before class");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\OneDrive\\Desktop\\Software Testing\\Selenium\\selenium files\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	
	@BeforeClass
	public void pom() {
		imdb = new Imdb(driver);
		
	}
	
	@BeforeMethod
	public void strtImdb() {
		System.out.println("before method");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Test() throws InterruptedException {
		imdb.srchtitle();
		imdb.imdb();
		imdb.src();
		imdb.ent();
		imdb.releaseDate();
	
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void closePage() {
		driver.close();
	}
	
	@AfterClass
	public void clearObject() {
		
		imdb= null;
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
	}
	

}
