package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;

public class TS_008_ShoppingCart extends Base{
	
	@Test(priority=1)
	public void Verify_ShoppingCart_Without_AddingProduct() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.linkText("My Cart")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/strong")).isDisplayed());
	}
	
	@Test(priority=2)
	public void Verify_ShoppingCart_After_AddingProduct() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Gear"))).perform();
		driver.findElement(By.linkText("Bags")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 400)");		
		action.moveToElement(driver.findElement(By.linkText("Push It Messenger Bag"))).perform();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button/span")).click();		
		jse.executeScript("scroll(0,-400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		Assert.assertTrue(driver.findElement(By.id("top-cart-btn-checkout")).isDisplayed());
	}
	
	@Test(priority=3)
	public void Verify_Edit_Item_From_ShoppingCart() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Push It Messenger Bag")).isDisplayed());
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("10");
		driver.findElement(By.id("product-updatecart-button")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).isDisplayed());
	
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("2");
		driver.findElement(By.id("product-updatecart-button")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Push It Messenger Bag was updated in your shopping')]")).isDisplayed());
	}
	
	@Test(priority=4)
	public void  Verify_Remove_Item_From_ShoppingCart() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		Thread.sleep(500);
		Assert.assertTrue(driver.findElement(By.linkText("Push It Messenger Bag")).isDisplayed());
		driver.findElement(By.cssSelector("a[title='Remove item']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
	}
}


