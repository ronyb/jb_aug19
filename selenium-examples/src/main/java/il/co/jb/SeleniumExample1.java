package il.co.jb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("John Bryce\n");
		
		WebElement appsButton = driver.findElement(By.className("gb_z"));
		appsButton.click();
	}
}
