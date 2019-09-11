package il.co.jb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubLandingPage extends AbstractPage {

	private static final By signInLink = By.xpath("//a[@href='/login']");
	private static final By signUpButton = By.cssSelector("div.HeaderMenu a[href='/join?source=header-home']");
	
	public GitHubLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickSignInLink() {
		driver.findElement(signInLink).click();
	}
	
	public void clickSignUpButton() {
		driver.findElement(signUpButton).click();
	}
}
