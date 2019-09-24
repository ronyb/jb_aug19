package il.co.jb.amazon.auto.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _003_AmazonLoginTest extends AbstractTest {

	@Test
	public void _003_AmazonLogin() {
		
		driver.get("http://amazon.com");
		
		Actions action = new Actions(driver);
		WebElement helloSignInLink = driver.findElement(By.id("nav-link-accountList"));
		
		action.moveToElement(helloSignInLink).build().perform();
		
		driver.findElement(By.xpath("//div[@id='nav-al-signin']//span[text()='Sign in']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("aa@bb.com");
		driver.findElement(By.id("ap_password")).sendKeys("123456");
		driver.findElement(By.id("signInSubmit")).click();
		
		WebElement warningMessageTitle = driver.findElement(By.xpath("//div[@id='auth-warning-message-box']//h4"));
		String warningMessageTitleText = warningMessageTitle.getText();
		
		Assert.assertEquals(warningMessageTitleText, "Important Message", "Wrong warning message");
	}
}
