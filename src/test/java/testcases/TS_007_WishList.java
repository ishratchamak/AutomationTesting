package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;

public class TS_007_WishList extends Base{

	@Test(priority=1)
	public void Verify_WishList_From_ProductPage() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		
		driver.findElement(By.id("search")).sendKeys("Winter Jacket");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
		driver.findElement(By.linkText("Hyperion Elements Jacket")).click();		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,400)");
		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[1]/div[5]/div[1]/a[1]/span[1]")).click();
	}
	
	@Test(priority=2)
	public void Verify_WishList_From_ProductPage_Without_Loggin() {
		driver.findElement(By.id("search")).sendKeys("Winter Jacket");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
		driver.findElement(By.linkText("Hyperion Elements Jacket")).click();		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,400)");
		driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[1]/div[5]/div[1]/a[1]/span[1]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'You must login or register to add items to your wi')]")).isDisplayed());
	}
	
	@Test(priority=3)
	public void Update_WishList_From_WishList_Page() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		
		driver.findElement(By.className("switch")).click();
		driver.findElement(By.linkText("My Wish List")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,400)");
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Update Wish List')]")).isDisplayed());
		driver.findElement(By.className("update")).click();
	}
	
	@Test(priority=4)
	public void Share_WishList_From_WishList_Page() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		
		driver.findElement(By.className("switch")).click();
		driver.findElement(By.linkText("My Wish List")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,400)");
		driver.findElement(By.name("save_and_share")).click();		
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Wish List Sharing')]")).isDisplayed());
		
		driver.findElement(By.id("email_address")).sendKeys("sonalisen123@gmail.com");
	}
}
