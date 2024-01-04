import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locator2 {
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Jayant");
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("jayantsharan@yahoo.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("jayantsharan@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9891602727");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordMsg = driver.findElement(By.cssSelector("form p")).getText();
		String password = passwordMsg.split("password '")[1].split("' to Login")[0].trim();
		driver.findElement(By.xpath("//form/div/button[1]")).click();
		Thread.sleep(1000);
		return password;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name = "Sharan";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = Locator2.getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Locate the Element -> id="inputUsername" 
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		//Locate the Password -> id="inputPassword"
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		//Check Box and T&C Check
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		
		//Press SignIn
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String welcomeMsg = driver.findElement(By.tagName("p")).getText();
		System.out.println(welcomeMsg);
		
		Assert.assertEquals(welcomeMsg, "You are successfully logged in.");
		String nameMsg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/h2")).getText();
		Assert.assertEquals(nameMsg, "Hello "+name+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		String signInMsg = driver.findElement(By.xpath("//*[text()='Sign In']")).getText();
		
		Assert.assertEquals(signInMsg,"SIGN IN");
		driver.close();
		driver.quit();
		
	}

}
