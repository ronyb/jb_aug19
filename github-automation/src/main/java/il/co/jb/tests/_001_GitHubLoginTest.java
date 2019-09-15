package il.co.jb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.jb.infra.pages.GitHubStartPage;

public class _001_GitHubLoginTest extends AbstractTest {

	@Test
	public void _001_GitHubLogin() {
		
		String username = "ronyb-jb";
		String password = "jbaug2019";
		
		GitHubStartPage gitHubStartPage = doLogin(username, password);
		
		gitHubStartPage.clickUserAvatar(username);
		String signedInAsUserLabel = gitHubStartPage.getSignedInAsLabel();
		
		Assert.assertEquals(signedInAsUserLabel, username, "Username on \"Signed in as\" label should be: " + username);
	}
}
