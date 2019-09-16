package il.co.jb.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.jb.infra.pages.GitHubCreateNewIssuePage;
import il.co.jb.infra.pages.GitHubCreateNewRepositoryPage;
import il.co.jb.infra.pages.GitHubExistingIssuePage;
import il.co.jb.infra.pages.GitHubLandingPage;
import il.co.jb.infra.pages.GitHubRepositoryCodePage;
import il.co.jb.infra.pages.GitHubRepositoryIssuesPage;
import il.co.jb.infra.pages.GitHubSignInPage;
import il.co.jb.infra.pages.GitHubStartPage;

public class CreateRepositoryAddIssueTest extends AbstractTest {

	@Test
	public void _234_createRepositoryAddIssueTest() {
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy - HH:mm:ss");
		Date testStartTime = new Date();
		
		String username = "ronyb-jb";
		String password = "jbaug2019";
		String repositoryName = "new-repo-" + dateFormat1.format(testStartTime);
		
		driver.get("https://github.com");
		
		GitHubLandingPage gitHubLandingPage = new GitHubLandingPage(driver);
		gitHubLandingPage.clickSignInLink();
		
		GitHubSignInPage gitHubSignInPage = new GitHubSignInPage(driver);
		gitHubSignInPage.writeUsername(username);
		gitHubSignInPage.writePassword(password);
		gitHubSignInPage.clickSignInButton();
		
		GitHubStartPage gitHubStartPage = new GitHubStartPage(driver);
		gitHubStartPage.clickStartProjectButton();
		
		GitHubCreateNewRepositoryPage gitHubCreateNewRepositoryPage = new GitHubCreateNewRepositoryPage(driver);
		gitHubCreateNewRepositoryPage.writeRepositoryName(repositoryName);
		gitHubCreateNewRepositoryPage.writeRepositoryDescription("This repository was created on: " + dateFormat2.format(testStartTime));
		gitHubCreateNewRepositoryPage.clickRepositoryVisibilityPrivateRadioButton();
		gitHubCreateNewRepositoryPage.clickCreateRepositoryButton();
		
		GitHubRepositoryCodePage gitHubRepositoryCodePage = new GitHubRepositoryCodePage(driver);
		gitHubRepositoryCodePage.clickIssuesTab(username, repositoryName);
		
		GitHubRepositoryIssuesPage gitHubRepositoryIssuesPage = new GitHubRepositoryIssuesPage(driver);
		gitHubRepositoryIssuesPage.clickNewIssueButton(username, repositoryName);
		
		GitHubCreateNewIssuePage gitHubCreateNewIssuePage = new GitHubCreateNewIssuePage(driver);
		
		String titleForNewIssue = "This is the issue title";
		gitHubCreateNewIssuePage.writeTitle(titleForNewIssue);
		gitHubCreateNewIssuePage.writeComment("This is the issue body");
		gitHubCreateNewIssuePage.clickSubmitNewIssueButton();
		
		GitHubExistingIssuePage gitHubExistingIssuePage = new GitHubExistingIssuePage(driver);
		String titleOnPage = gitHubExistingIssuePage.getTitle();
		
		Assert.assertEquals(titleOnPage, titleForNewIssue, "Issue title should be: '" + titleForNewIssue + "'");
	}
}
