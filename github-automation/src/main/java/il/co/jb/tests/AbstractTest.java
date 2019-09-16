package il.co.jb.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import il.co.jb.infra.pages.GitHubLandingPage;
import il.co.jb.infra.pages.GitHubSignInPage;
import il.co.jb.infra.pages.GitHubStartPage;
import il.co.jb.infra.web.BrowserType;
import il.co.jb.infra.web.WebDriverFactory;

public abstract class AbstractTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		if (driver == null) {
			driver = WebDriverFactory.getDriver(BrowserType.CHROME);
		}
	}
	
	public GitHubStartPage doLogin(String username, String password) {
		
		driver.get("https://github.com");
		
		GitHubLandingPage gitHubLandingPage = new GitHubLandingPage(driver);
		gitHubLandingPage.clickSignInLink();
		
		GitHubSignInPage gitHubSignInPage = new GitHubSignInPage(driver);
		gitHubSignInPage.writeUsername(username);
		gitHubSignInPage.writePassword(password);
		gitHubSignInPage.clickSignInButton();
		
		GitHubStartPage gitHubStartPage = new GitHubStartPage(driver);
		return gitHubStartPage;
	}
	
	/*
	protected void initWebDriver() {
		
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	*/
}
