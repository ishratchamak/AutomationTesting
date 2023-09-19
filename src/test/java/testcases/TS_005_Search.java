package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import basic.Base;

public class TS_005_Search extends Base{
	
	@Test(priority=1)
	public void Verify_SearchIcon() {
		driver.findElement(By.id("search")).sendKeys("Winter Jacket");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
	}
	
	@Test(priority=2)
	public void Verify_Search_With_EnterButton() {
		driver.findElement(By.id("search")).sendKeys("Winter Jacket");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).sendKeys(Keys.ENTER);
	}

	@Test(priority=3)
	public void Verify_Search_With_NonExisting_Product() {
		driver.findElement(By.id("search")).sendKeys("Samsung");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your search returned no results.')]")).isDisplayed());
	}
}
