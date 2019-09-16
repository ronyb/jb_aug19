package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubCreateNewIssuePage extends AbstractPage {

	private static final By titleInput = By.id("issue_title");
	private static final By commentTextarea = By.id("issue_body");
	private static final By submitNewIssueButton = By.cssSelector(".timeline-comment button[type='submit'].btn");
	
	public GitHubCreateNewIssuePage(WebDriver driver) {
		super(driver);
	}
	
	public void writeTitle(String title) {
		driver.findElement(titleInput).sendKeys(title);
	}
	
	public void writeComment(String comment) {
		driver.findElement(commentTextarea).sendKeys(comment);
	}
	
	public void clickSubmitNewIssueButton() {
		driver.findElement(submitNewIssueButton).click();
	}
}
