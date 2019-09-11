package il.co.jb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import il.co.jb.pages.GitHubCreateNewRepositoryPage;
import il.co.jb.pages.GitHubLandingPage;
import il.co.jb.pages.GitHubRepositoryCodePage;
import il.co.jb.pages.GitHubRepositoryIssuesPage;
import il.co.jb.pages.GitHubSignInPage;
import il.co.jb.pages.GitHubStartPage;

public class CreateRepositoryAddIssueTest_PO {

	@Test
	public void _234_createRepositoryAddIssueTest() {
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy - HH:mm:ss");
		Date testStartTime = new Date();
		
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
	}
}
