package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubStartPage extends AbstractPage {

	private static final By startProjectButton = By.xpath("//div[contains(@class,'shelf-content')]/a[@href='/new']");
	private static final By signedInAsLabel = By.cssSelector("strong.css-truncate-target");
	
	public GitHubStartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickStartProjectButton() {
		driver.findElement(startProjectButton).click();
	}
	
	public void clickUserAvatar(String username) {
		By userAvatarImage = By.xpath("(//img[@alt='@" + username + "'])[2]");
		driver.findElement(userAvatarImage).click();
	}
	
	public String getSignedInAsLabel() {
		return driver.findElement(signedInAsLabel).getText();
	}
}
