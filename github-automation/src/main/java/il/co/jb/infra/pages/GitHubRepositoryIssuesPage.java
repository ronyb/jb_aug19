package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubRepositoryIssuesPage extends AbstractPage {
	
	public GitHubRepositoryIssuesPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickNewIssueButton(String username, String repositoryName) {
		By newIssueButton = By.xpath("//div[@class='subnav']/a[@href='/" + username + "/" + repositoryName + "/issues/new']");
		driver.findElement(newIssueButton).click();
	}
}
