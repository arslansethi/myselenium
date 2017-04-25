package sele;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import org.junit.Test;

public class Funda {
	public static WebDriver driver;
	@BeforeClass
    public static void setupTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium driver\\geckodriver.exe");
        driver = new FirefoxDriver();
}

	@Test
    public void checkTitleTest() throws InterruptedException {
       
        driver.navigate().to("http://www.funda.nl");
        driver.manage().window().maximize();
        assertThat(driver.getTitle(), is("Zoek huizen en appartementen te koop in Nederland [funda]"));
        System.out.println("I m here");
        Thread.sleep(4000);
      
        driver.findElement(By.id("autocomplete-input")).click();
    	driver.findElement(By.id("autocomplete-input")).sendKeys("Almere");
    	driver.findElement(By.id("autocomplete-input")).sendKeys(Keys.TAB);
    	System.out.println("Now I m here");
    	Select dropdown = new Select(driver.findElement(By.id("Afstand")));
		dropdown.selectByIndex(1);
		Thread.sleep(1000);
		Select dropdown1 = new Select(driver.findElement(By.id("range-filter-selector-select-filter_fundakoopprijsvan")));
		dropdown1.selectByIndex(2);
		Select dropdown2 = new Select(driver.findElement(By.id("range-filter-selector-select-filter_fundakoopprijstot")));
		dropdown2.selectByIndex(5);
		Thread.sleep(1000);
		WebElement zoek_button = driver.findElement(By.cssSelector(".button-primary-alternative"));
		zoek_button.click();
		}
//    @Test
//    public void check_Text_field_Is_Empty() throws InterruptedException
//    
//    {
//    	  System.out.println("Now I m here");
//    	driver.findElement(By.id("autocomplete-input")).click();
//    	driver.findElement(By.id("autocomplete-input")).sendKeys("a");
//    	Thread.sleep(4000);
//    	//driver.findElement(By.id("autocomplete-input")).sendKeys("aa");
//    	    	//assertThat(driver.findElement(By.id("autocomplete-input")),is(""));
//    	
////    	WebElement element = driver.findElement(By.xpath("//*[@class='/html/body/main/div[1]/div[4]/form/nav/ul/li[2]/a']"));
////		element.click();
//    	
//    }
}
