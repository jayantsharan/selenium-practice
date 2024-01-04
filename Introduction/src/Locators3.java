import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3 {

	public static void main(String[] args) {
		// Sibling - Child to parent traverse
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//header/div/button[1]/following-sibling::button[1]
		String buttonText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(buttonText);
		String buttonTag = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getTagName();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		Assert.assertEquals(buttonText, "Login");
		driver.quit();
		

	}

}
