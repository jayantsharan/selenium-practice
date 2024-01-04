import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		Boolean ifSelected = driver.findElement(By.id("checkBoxOption1")).isSelected();
		//Assert to check the checkbox is selected
		Assert.assertEquals(ifSelected, true);
		if(ifSelected) {
			driver.findElement(By.id("checkBoxOption1")).click();
		}
		ifSelected = driver.findElement(By.id("checkBoxOption1")).isSelected();
		//Assert to ensure the check box is not selected
		Assert.assertEquals(ifSelected, false);
		
		/*Total number of check box on the page*/
		List<WebElement> chkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int total_checkbox = chkbox.size();
		System.out.println("Total Number of CheckBox: " + total_checkbox);
		}
	}


