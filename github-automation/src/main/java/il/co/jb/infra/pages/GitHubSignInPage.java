package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.infra.web.By2;

public class GitHubSignInPage extends AbstractPage {

	private static final By2 usernameInput = new By2("'Username' input", By.id("login_field"));
	private static final By2 passwordInput = new By2("'Password' input", By.id("password"));
	private static final By2 signInButton = new By2("'Sign in' button", By.xpath("//input[@name='commit']"));
	
	public GitHubSignInPage(WebDriver driver) {
		super(driver);
	}
	
	public void writeUsername(String username) {
		
		bot.writeToElement(usernameInput, username);
		
//		report.log("Write '" + username + "' to: " + usernameInput);
//		driver.findElement(usernameInput.by).sendKeys(username);
	}
	
	public void writePassword(String password) {
		
		bot.writeToElement(passwordInput, password);
		
//		report.log("Write '" + password + "' to: " + passwordInput);
//		driver.findElement(passwordInput.by).sendKeys(password);
	}
	
	public void clickSignInButton() {
		
		bot.click(signInButton);
		
//		report.log("Click: " + signInButton);
//		driver.findElement(signInButton.by).click();
	}
}
