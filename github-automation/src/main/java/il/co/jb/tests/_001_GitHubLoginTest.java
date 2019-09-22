package il.co.jb.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.jb.infra.config.MainConfig;
import il.co.jb.infra.pages.GitHubStartPage;
import il.co.jb.infra.utils.AssertUtils;

public class _001_GitHubLoginTest extends AbstractTest {

	private int param1;
	private String param2;
	
	@Test
	public void _001_GitHubLogin() throws Exception {
		
		initParams();
		
		// Step 1 - Perform login
		report.startLevel("Step 1 - Perform login");
		GitHubStartPage gitHubStartPage = doLogin(MainConfig.username, MainConfig.password);
		report.endLevel();
		
		// Step 2 - Verify "Signed in as..." label shows correct username
		report.startLevel("Step 2 - Verify \"Signed in as...\" label shows correct username");
		gitHubStartPage.clickUserAvatar(MainConfig.username);
		String signedInAsUserLabel = gitHubStartPage.getSignedInAsLabel();
		AssertUtils.assertEquals(signedInAsUserLabel, MainConfig.username, "Username on \"Signed in as\" label should be: " + MainConfig.username);
		report.endLevel();
	}
	
	private void initParams() throws Exception {
		
		InputStream input = new FileInputStream("src/main/resources/_001_GitHubLoginTest.properties");
		Properties prop = new Properties();
		prop.load(input);

		param1 = Integer.parseInt(prop.getProperty("param1"));
		param2 = prop.getProperty("param2");
	}
}
