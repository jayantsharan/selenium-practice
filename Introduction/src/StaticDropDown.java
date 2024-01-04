import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropDown {
	
	public static void assertAndPrint(WebDriver driver,Select dropdown,String Text) {
		String selectedText = dropdown.getFirstSelectedOption().getText();
		System.out.println(selectedText);
		Assert.assertEquals(selectedText, Text);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//Drpdown with select tag
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByIndex(3);
		assertAndPrint(driver, dropdown, "USD");
		
		dropdown.selectByVisibleText("AED");
		assertAndPrint(driver, dropdown, "AED");
		
		dropdown.selectByValue("INR");
		assertAndPrint(driver, dropdown, "INR");
		
		
		
		
		

	}

}
