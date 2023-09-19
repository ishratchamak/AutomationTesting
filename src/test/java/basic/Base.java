package basic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver = null;
	
	@BeforeMethod
	public void setup() {		
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));	
		driver.get("https://magento.softwaretestingboard.com/");
		
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
