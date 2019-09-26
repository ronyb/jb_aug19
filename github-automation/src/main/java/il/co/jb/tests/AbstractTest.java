package il.co.jb.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.jb.infra.config.MainConfig;
import il.co.jb.infra.pages.GitHubLandingPage;
import il.co.jb.infra.pages.GitHubSignInPage;
import il.co.jb.infra.pages.GitHubStartPage;
import il.co.jb.infra.web.WebDriverFactory;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTest {

	protected WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();

	@BeforeMethod // this method will be executed before each @Test
	public void beforeMethod() throws Exception {

		MainConfig.initFromFile("src/main/resources/MainConfig.properties");

		if (driver == null) {
			driver = WebDriverFactory.getDriver(MainConfig.browserType);
		}
	}

	public GitHubStartPage doLogin(String username, String password) {

		browseToUrl(MainConfig.baseUrl);

		GitHubLandingPage gitHubLandingPage = new GitHubLandingPage(driver);
		gitHubLandingPage.clickSignInLink();

		GitHubSignInPage gitHubSignInPage = new GitHubSignInPage(driver);
		gitHubSignInPage.writeUsername(username);
		gitHubSignInPage.writePassword(password);
		gitHubSignInPage.clickSignInButton();

		GitHubStartPage gitHubStartPage = new GitHubStartPage(driver);
		return gitHubStartPage;
	}

	protected void browseToUrl(String url) {
		report.log("Browse to URL: " + url);
		driver.get(url);
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
