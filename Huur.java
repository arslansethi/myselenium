package sele;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Huur {

	public static WebDriver driver;
	@BeforeClass
    public static void setupTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium driver\\geckodriver.exe");
        driver = new FirefoxDriver();
}
	@Test
    public void Huur_tab () throws InterruptedException 
    {
		driver.navigate().to("http://www.funda.nl");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector(".search-block__navigation-items > li:nth-child(2) > a:nth-child(1)")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.id("autocomplete-input")).click();
	    driver.findElement(By.id("autocomplete-input")).sendKeys("Almere");
	    driver.findElement(By.id("autocomplete-input")).sendKeys(Keys.TAB);
	   	System.out.println("Now I m here");
	   	Select dropdown = new Select(driver.findElement(By.id("Afstand")));
		dropdown.selectByIndex(2);
		Thread.sleep(1000);
		System.out.println("Now I m here2");
		Thread.sleep(1000);
		Select dropdown1 = new Select(driver.findElement(By.id("range-filter-selector-select-filter_fundahuurprijsvan")));
		dropdown1.selectByIndex(2);
		Select dropdown2 = new Select(driver.findElement(By.id("range-filter-selector-select-filter_fundahuurprijstot")));
		dropdown2.selectByIndex(5);
		Thread.sleep(1500);
		WebElement zoek_button = driver.findElement(By.cssSelector(".button-primary-alternative"));
		zoek_button.click();
    }

}
