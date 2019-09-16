package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubRepositoryCodePage extends AbstractPage  {

	public GitHubRepositoryCodePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickIssuesTab(String username, String repositoryName) {
		By issuesTab = By.xpath("//a[@href='/" + username + "/" + repositoryName + "/issues']");
		driver.findElement(issuesTab).click();
	}
}
