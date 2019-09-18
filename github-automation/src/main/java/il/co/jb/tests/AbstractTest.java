package il.co.jb.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.jb.infra.pages.GitHubLandingPage;
import il.co.jb.infra.pages.GitHubSignInPage;
import il.co.jb.infra.pages.GitHubStartPage;
import il.co.jb.infra.web.BrowserType;
import il.co.jb.infra.web.WebDriverFactory;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTest {

	protected WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		if (driver == null) {
			driver = WebDriverFactory.getDriver(BrowserType.CHROME);
		}
	}
	
	public GitHubStartPage doLogin(String username, String password) {
		
		String url = "https://github.com";
		report.log("Browse to URL: " + url);
		driver.get(url);
		
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
