import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Invoke Browser
		
//		ChromeOptions options = new ChromeOptions();
//      options.addArguments("--remote-allow-origins=*");
		//WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String myUrl = driver.getCurrentUrl();
		System.out.println(myUrl);
		driver.close();
		driver.quit();
	}

}
