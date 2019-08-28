package il.co.jb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHubAutomation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		
		WebElement usernameInput = driver.findElement(By.id("login_field"));
		usernameInput.sendKeys("ronyb-jb");
		
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("jbaug2019");
		
		WebElement signInButton = driver.findElement(By.cssSelector("[name='commit']"));
		signInButton.click();
	}
}
