package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;
import imp.Utilities;

public class TS_002_SignIn extends Base{
	
	@Test(priority=1)
	public void Login_With_Valid_Information() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
	}
	
	@Test(priority=2)
	public void Login_With_ValidEmail_and_InvalidPassword() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sonali@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("888888888888");
		driver.findElement(By.id("send2")).click();
		
		String warning = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account ')]")).getText();
		Assert.assertEquals(warning, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", "Warning message is not correct");
	}
	
	@Test(priority=3)
	public void Login_With_InvalidEmail_and_ValidPassword() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(Utilities.GenerateEmailWithTimeStamp());
		driver.findElement(By.id("pass")).sendKeys("Ss123456*");
		driver.findElement(By.id("send2")).click();
		
		String warning = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account ')]")).getText();
		Assert.assertEquals(warning, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", "Warning message is not correct");
	}
	
	@Test(priority=4)
	public void Login_Without_Info() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.id("send2")).click();
		
		String msg1 = driver.findElement(By.id("email-error")).getText();
		Assert.assertEquals(msg1, "This is a required field.");
		
		String msg2 = driver.findElement(By.id("pass-error")).getText();
		Assert.assertEquals(msg2, "This is a required field.");
	}
}
