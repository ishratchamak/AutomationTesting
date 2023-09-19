package testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;

public class TS_004_SignOut extends Base{

	@Test(priority=1)
	public void Verify_Signout_from_Dropdown() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]")).isDisplayed());
	}	
}
