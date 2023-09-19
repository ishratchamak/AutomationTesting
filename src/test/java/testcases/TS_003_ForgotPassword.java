package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;

public class TS_003_ForgotPassword extends Base{
	
	@Test(priority=1)
	public void Verify_ForgotPassword_Link() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		driver.findElement(By.id("email_address")).sendKeys("sonali@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Reset My Password')]")).click();
		
		String msg = driver.findElement(By.xpath("//div[contains(text(),'If there is an account associated with sonali@gmai')]")).getText();
		Assert.assertEquals(msg, "If there is an account associated with sonali@gmail.com you will receive an email with a link to reset your password.");
	}
	
	@Test(priority=2)
	public void Verify_ForgotPassword_Without_Email() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		driver.findElement(By.id("email_address")).sendKeys("");
		driver.findElement(By.xpath("//span[contains(text(),'Reset My Password')]")).click();
		
		Assert.assertTrue(driver.findElement(By.id("email_address-error")).isDisplayed());
		}
	
	@Test(priority=3)
	public void Verify_ForgotPassword_With_NonExitingEmail() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		driver.findElement(By.id("email_address")).sendKeys("abcdef@yahoo.com");
		driver.findElement(By.xpath("//span[contains(text(),'Reset My Password')]")).click();		
	}
}