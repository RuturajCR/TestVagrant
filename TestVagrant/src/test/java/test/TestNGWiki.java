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
import org.testng.asserts.SoftAssert;

import pom.Wiki;

public class TestNGWiki {
	
	WebDriver driver;
	Wiki wiki;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("before class");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\OneDrive\\Desktop\\Software Testing\\Selenium\\selenium files\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	
	@BeforeClass
	public void pom() {
		wiki = new Wiki(driver);
		
	}
	
	@BeforeMethod
	public void strtImdb() {
		System.out.println("before method");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void Test() throws InterruptedException {
		wiki.search();
		wiki.src();
		wiki.clickwiki();
		
		String title = driver.getTitle();
		String expectedtitle= "Pushpa: The Rise - Wikipedia";
		boolean ispresent = title.contains(expectedtitle);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(ispresent, "Test Case Is Passed");
		System.out.println("Passed");
		sa.assertAll();
		
		wiki.releaseDate();
		wiki.getCountry();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closePage() {
		driver.close();
	}
	
	@AfterClass
	public void clearObject() {
		
		wiki= null;
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
	}

}
