package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.infra.web.By2;

public class GitHubLandingPage extends AbstractPage {

	private static final By2 signInLink = new By2("'Sign in' link", By.xpath("//a[@href='/login']"));
	private static final By2 signUpButton = new By2("'Sign up' button", By.cssSelector("div.HeaderMenu a[href='/join?source=header-home']"));
	
	public GitHubLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickSignInLink() {
		
		bot.click(signInLink);
		
//		report.log("Click: " + signInLink);
//		driver.findElement(signInLink.by).click();
	}
	
	public void clickSignUpButton() {
		
		bot.click(signUpButton);
		
//		report.log("Click: " + signUpButton);
//		driver.findElement(signUpButton.by).click();
	}
}
