package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wiki {
	
	@FindBy(xpath="//input[@type='text']")
	WebElement srchpushpa;
	
	@FindBy(xpath="(//input[@value='Google Search'])[2]")
	WebElement srch;
	
	@FindBy(xpath="//h3[text()='Pushpa: The Rise - Wikipedia']")
	WebElement clkwiki;
	
	@FindBy(xpath="(//div[@class='plainlist'])[4]")
	WebElement release;
	
	@FindBy(xpath="//td[text()='India']")
	WebElement country;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Wiki(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void search() {
		
        srchpushpa.sendKeys("pushpa the rise hindi wikipedia");	
	}
	
	public void src() {
		srch.click();
	}
	
	public void clickwiki() {
		
		clkwiki.click();
	}
	
	public void releaseDate() {
		
		wait= new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOf(release));
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", release);
    	String til= release.getText();
    	System.out.println(til);
  
    	
	}
	
	public void getCountry() {
		
		String count = country.getText();
		System.out.println(count);
	}

}
