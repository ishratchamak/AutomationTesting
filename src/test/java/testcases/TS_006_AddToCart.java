package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;

public class TS_006_AddToCart extends Base{
	
	@Test(priority=1)
	public void Verify_AddtoCart_Without_Selecting_SizeandColor() {
		driver.findElement(By.id("search")).sendKeys("Winter Jacket");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
		driver.findElement(By.linkText("Hyperion Elements Jacket")).click();
		driver.findElement(By.id("product-addtocart-button")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"super_attribute[143]-error\"]")).isDisplayed());
	}
	
	@Test(priority=2)
	public void Verify_AddtoCart_With_Selecting_SizeandColor() {
		driver.findElement(By.id("search")).sendKeys("Winter Jacket");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
		driver.findElement(By.linkText("Hyperion Elements Jacket")).click();
		driver.findElement(By.id("option-label-size-143-item-169")).click();
		driver.findElement(By.id("option-label-color-93-item-53")).click();		
		driver.findElement(By.id("product-addtocart-button")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).isDisplayed());
	}
	
	@Test(priority=3)
	public void Verify_AddToCart_From_WishList() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a")).click();
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scroll(0,300)");
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/form[1]/div[1]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]/img[1]"))).perform();
//		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/form[1]/div[1]/ol[1]/li[1]/div[1]/div[3]/div[2]/fieldset[1]/div[2]/div[1]/button[1]/span[1]")).click();
//
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'You added Driven Backpack to your shopping cart.')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'You have no items in your wish list.')]")).isDisplayed());		
	}
	
	@Test(priority=4)
	public void Verify_AddALLToCart_From_WishList() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,700)");
		driver.findElement(By.xpath("//span[contains(text(),'Add All to Cart')]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Please specify product option(s) for \"Sprite Yoga ')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Please specify the quantity of product(s) for \"Set')]")).isDisplayed());
	}
	
	
}
