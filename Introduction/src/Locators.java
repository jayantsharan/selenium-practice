import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Open the URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Locate the Element -> id="inputUsername" 
		driver.findElement(By.id("inputUsername")).sendKeys("Jayant");
		
		//Locate the Password -> id="inputPassword"
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		
		
		//Press SignIn
		driver.findElement(By.className("signInBtn")).click();
		
		String msg = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(msg);
		
		//Check if Password is incorrect then generate new password
		if(msg.contains("Incorrect username or password")) {
			driver.findElement(By.linkText("Forgot your password?")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Jayant");
			driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("jayantsharan@yahoo.com");
			driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
			driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("jayantsharan@gmail.com");
			driver.findElement(By.xpath("//form/input[3]")).sendKeys("9891602727");
			driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
			String passwordMsg = driver.findElement(By.cssSelector("form p")).getText();
			System.out.println(passwordMsg);
			driver.findElement(By.xpath("//form/div/button[1]")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
			//Locate the Element -> id="inputUsername" 
			driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Jayant");
			//Locate the Password -> id="inputPassword"
			driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
			//Check Box and T&C Check
			driver.findElement(By.id("chkboxOne")).click();
			driver.findElement(By.id("chkboxTwo")).click();
			
			//Press SignIn
			driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}
}
