package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import basic.Base;

public class TS_009_CheckOut extends Base{

	@Test(priority=1)
	public void Verify_Checkout_With_RequiredInfrmation() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		
		Thread.sleep(2000);	
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 800)");
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();	
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Thank you for your purchase!')]")).isDisplayed());
		
		System.out.println("Your Order Number is: " + driver.findElement(By.className("order-number")).getText());
	}
	
	@Test(priority=2)
	public void Verify_Checkout_Without_Login() throws InterruptedException {
		driver.findElement(By.linkText("Gear")).click();
		driver.findElement(By.linkText("Bags")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 400)");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Overnight Duffle"))).perform();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[3]/div/div[1]/form/button/span")).click();		
		jse.executeScript("scroll(0,-400)");
		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		driver.findElement(By.name("firstname")).sendKeys("Sonali");
		driver.findElement(By.name("lastname")).sendKeys("Sen");
		driver.findElement(By.name("street[0]")).sendKeys("13th Street. 47 W 13th St, New York, NY 10011, USA");
		driver.findElement(By.name("city")).sendKeys("America");
		
		WebElement element = driver.findElement(By.name("region_id"));
		Select select = new Select(element);		
		select.selectByValue("3");
		
		driver.findElement(By.name("postcode")).sendKeys("10017");
		
		WebElement element2 = driver.findElement(By.name("country_id"));
		Select select2 = new Select(element2);
		select2.selectByValue("US");		
		driver.findElement(By.name("telephone")).sendKeys("(812) 421-9282");
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer-email-error\"]")).isDisplayed());
	}
}
