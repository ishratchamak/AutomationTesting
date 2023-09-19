package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;

public class TS_001_Registration extends Base{
	
	@Test(priority=1)
	public void Registration_With_Valid_info() {
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.id("firstname")).sendKeys("Sonali");
		driver.findElement(By.id("lastname")).sendKeys("Sen");
		driver.findElement(By.id("email_address")).sendKeys("sonali@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ss123456*");
		driver.findElement(By.id("password-confirmation")).sendKeys("Ss123456*");
		
		driver.findElement(By.className("submit")).click();	
		
//		String message = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
//		System.out.println(message);
//		Assert.assertEquals(message, "Thank you for your registering with Main Website Store.", "Erroooooor");
//		
//		Assert.assertTrue(driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]")).isDisplayed());
//		String msg = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
//		
//		System.out.println(msg);
//		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).isDisplayed());
	}
	
	@Test(priority=2)
	public void Registration_Without_info() {
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.className("submit")).click();
		
		System.out.println("First Name: " + driver.findElement(By.id("firstname-error")).getText());
		System.out.println("Last Name: " + driver.findElement(By.id("lastname-error")).getText());
		System.out.println("Email: " + driver.findElement(By.id("email_address-error")).getText());
		System.out.println("Password: " + driver.findElement(By.id("password-error")).getText());
		System.out.println("Confrim Password: " + driver.findElement(By.id("password-confirmation-error")).getText());
	}
	
	@Test(priority=3)
	public void Regstration_With_SpecialCharacters() {
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.id("firstname")).sendKeys("!@#$%^&");
		driver.findElement(By.id("lastname")).sendKeys("!@#$%^&");
		driver.findElement(By.id("email_address")).sendKeys("!@#$%^&");
		driver.findElement(By.id("password")).sendKeys("!@#$%^&");
		driver.findElement(By.id("password-confirmation")).sendKeys("!@#$%^&");
		
		driver.findElement(By.className("submit")).click();	
		
		String messagge = driver.findElement(By.id("email_address-error")).getText();
		Assert.assertEquals(messagge, "Please enter a valid email address (Ex: johndoe@domain.com).", "Errooor");
		
		String message = driver.findElement(By.id("password-error")).getText();
		Assert.assertEquals(message, "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.", "Errooor");
	}

}
