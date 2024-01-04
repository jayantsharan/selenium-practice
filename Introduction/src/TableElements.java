import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
				
		List<WebElement> vals =  driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
		
		ArrayList<Float> listofval = new ArrayList<>();
		for(WebElement we : vals) {
			String val = we.getText();
			listofval.add(Float.parseFloat(val));
		}
		
		Collections.sort(listofval);
		System.out.println(listofval);
	}

}
