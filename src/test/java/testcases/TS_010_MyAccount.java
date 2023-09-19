package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;
public class TS_010_MyAccount extends Base{

	@Test(priority=1)
	public void Navigating_MyAccount_page() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.linkText("My Account")).click();
		String actual = driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).getText();
		Assert.assertEquals(actual, "My Account", "Error Shows...");
	}
	
	@Test(priority=2)
	public void Navigating_Edit_From_MyAccount_page() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Sengupta");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Sen");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
	}
	
	@Test(priority=3)
	public void Navigating_MyAccount() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.linkText("My Account")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]")).getText());
	}
}
