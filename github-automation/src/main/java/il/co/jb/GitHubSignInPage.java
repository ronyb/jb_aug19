package il.co.jb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubSignInPage {

	private WebDriver driver;
	
	By usernameInput = By.id("login_field");
	By passwordInput = By.id("password");
	By signInButton = By.xpath("//input[@name='commit']");
	
	public GitHubSignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void writeUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	
	public void writePassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}
}
