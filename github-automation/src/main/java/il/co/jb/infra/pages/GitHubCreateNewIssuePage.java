package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.infra.web.By2;

public class GitHubCreateNewIssuePage extends AbstractPage {

	private static final By2 titleInput = new By2("'Title' input", By.id("issue_title"));
	private static final By2 commentTextarea = new By2("'Comment' textarea", By.id("issue_body"));
	private static final By2 submitNewIssueButton = new By2("'Submit new issue' button", By.cssSelector(".timeline-comment button[type='submit'].btn"));
	
	public GitHubCreateNewIssuePage(WebDriver driver) {
		super(driver);
	}
	
	public void writeTitle(String title) {
		driver.findElement(titleInput.by).sendKeys(title);
	}
	
	public void writeComment(String comment) {
		driver.findElement(commentTextarea.by).sendKeys(comment);
	}
	
	public void clickSubmitNewIssueButton() {
		driver.findElement(submitNewIssueButton.by).click();
	}
}
