package il.co.jb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTest {

	@Test
	public void amazonSearchTest() {
	
		String searchTerm = "iPhone";
		
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		WebElement mainSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		mainSearchBox.sendKeys(searchTerm);
		
		driver.findElement(By.cssSelector("[value='Go']")).click();
		
		WebElement firstSearchResultHeader = driver.findElement(By.cssSelector("div[data-index='5'] h2"));
		String firstSearchResultValue = firstSearchResultHeader.getText();
		
		Assert.assertTrue(firstSearchResultValue.contains(searchTerm),
				"First search result '" + firstSearchResultValue + "' should contain the search term: '" + searchTerm + "'");
	}
}
