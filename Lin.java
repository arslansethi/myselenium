import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Lin {
public static WebDriver driver;
	
	@BeforeClass
    public static void setupTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium driver\\geckodriver.exe");
        driver = new FirefoxDriver();
}
	@Test
    public void checkTitleTest() {
       
        driver.navigate().to("http://www.linkedin.com");
        //Maximize the browser
        driver.manage().window().maximize();
        //Check the title
        assertThat(driver.getTitle(), is("LinkedIn: Log In or Sign Up"));     
		}
	@Test
	public void sin() throws InterruptedException //Method for SignIn
	{
		driver.findElement(By.id("login-email")).sendKeys("<Email Address>");
		driver.findElement(By.id("login-password")).sendKeys("<password>");
		driver.findElement(By.id("login-submit")).click();
		System.out.println("Entering homepage");
		Thread.sleep(4000);
		System.out.println("inside");
	}
	
	@Test
	public void home_page() throws InterruptedException //Method for Post
	{ 
		assertThat(driver.getTitle(), is("LinkedIn"));
		System.out.println("i m here");
		WebElement element = driver.findElement(By.cssSelector(".sharing-posting-options--is-disabled"));
		element.click();
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath("//*[@class='sharing-textarea__textarea sharing-textarea__textarea--original ember-text-area ember-view']"));
		ele.sendKeys("Test Post-Generated using Selenium Webdriver");
		System.out.println("Text is in");
		WebElement element1 = driver.findElement(By.cssSelector(".sharing-share-box__post-button-container"));
		element1.click();
		System.out.println("Posted");
	}
	@AfterClass
	public static void browser_close() //Method For Closing browser
	{
		driver.quit();
	}
	}


