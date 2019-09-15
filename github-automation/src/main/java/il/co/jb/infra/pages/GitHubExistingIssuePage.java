package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubExistingIssuePage extends AbstractPage {

	private static final By titleSpan = By.cssSelector("h1.gh-header-title > .js-issue-title");
	
	public GitHubExistingIssuePage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return driver.findElement(titleSpan).getText();
	}
}
