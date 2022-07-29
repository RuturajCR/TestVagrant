package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Imdb {
	
	@FindBy(xpath="//input[@type='text']")
	WebElement srchimd;
	
	@FindBy(xpath="(//cite[text()='https://www.imdb.com'])[1]")
	WebElement clkimd;
	
	@FindBy(xpath= "//input[@type='text']")
	WebElement srchmovie;

	
	@FindBy(xpath= "//a[text()='Pushpa: The Rise - Part 1']")
	WebElement enter;
	
	@FindBy(xpath= "//a[text()='January 7, 2022 (United States)']")
	WebElement date;
	
	private Actions action;
	private WebDriver driver;
	private WebDriverWait wait;

	
	public Imdb (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		this.driver=driver;
	}
	
	public void srchtitle() {
		
		action.sendKeys(srchimd,"imdb.com").sendKeys(Keys.ENTER).build().perform();
	}
	
	public void imdb() {
		
		clkimd.click();
	}
	
	public void src() {
		
		action.sendKeys(srchmovie,"Pushpa: The Rise - Part 1").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	
	}
	
    public void ent()
    {
    	enter.click();
    }
    
    public void releaseDate()  {
    	wait= new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.visibilityOf(date));
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", date);
    	String til= date.getText();
    	System.out.println(til);
   
    }
	
	

}
