package il.co.jb.tests;

import org.testng.annotations.Test;

import il.co.jb.infra.pages.GitHubStartPage;
import il.co.jb.infra.utils.AssertUtils;

public class _001_GitHubLoginTest extends AbstractTest {

	@Test
	public void _001_GitHubLogin() {
		
		String username = "ronyb-jb";
		String password = "jbaug2019";
		
		// Step 1 - Perform login
		report.startLevel("Step 1 - Perform login");
		GitHubStartPage gitHubStartPage = doLogin(username, password);
		report.endLevel();
		
		// Step 2 - Verify "Signed in as..." label shows correct username
		report.startLevel("Step 2 - Verify \"Signed in as...\" label shows correct username");
		gitHubStartPage.clickUserAvatar(username);
		String signedInAsUserLabel = gitHubStartPage.getSignedInAsLabel();
		AssertUtils.assertEquals(signedInAsUserLabel, username, "Username on \"Signed in as\" label should be: " + username);
		report.endLevel();
	}
}
