package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubSignInPage extends AbstractPage {

	private static final By usernameInput = By.id("login_field");
	private static final By passwordInput = By.id("password");
	private static final By signInButton = By.xpath("//input[@name='commit']");
	
	public GitHubSignInPage(WebDriver driver) {
		super(driver);
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
