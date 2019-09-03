package il.co.jb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateRepositoryAddIssueTest {

	@Test
	public void createRepositoryAddIssueTest() throws InterruptedException {
		
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
		
		//driver.findElement(By.cssSelector("a[href='/login']")).click();
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
		WebElement usernameInput = driver.findElement(By.id("login_field"));
		usernameInput.sendKeys(username);
		
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		
		//WebElement signInButton = driver.findElement(By.cssSelector("input[name='commit']"));
		WebElement signInButton = driver.findElement(By.xpath("//input[@name='commit']"));
		signInButton.click();
		
		//WebElement startProjectButton = driver.findElement(By.cssSelector(".shelf-content a[href='/new']"));
		//WebElement startProjectButton = driver.findElement(By.xpath("//a[text()='Start a project']"));
		WebElement startProjectButton = driver.findElement(By.xpath("//div[contains(@class,'shelf-content')]/a[@href='/new']"));
		startProjectButton.click();
		
		driver.findElement(By.id("repository_name")).sendKeys(repositoryName);
		driver.findElement(By.id("repository_description")).sendKeys("This repository was created on: " + dateFormat2.format(testStartTime));
		
		driver.findElement(By.id("repository_visibility_private")).click();
		//driver.findElement(By.cssSelector(".js-with-permission-fields > [type='submit']")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'Create repository')]")).click();
		driver.findElement(By.xpath("//div[@class='js-with-permission-fields']/button[@type='submit']")).click();
		
		//WebElement issuesTab = driver.findElement(By.cssSelector("[href='/" + username + "/" + repositoryName + "/issues']"));
		WebElement issuesTab = driver.findElement(By.xpath("//a[@href='/" + username + "/" + repositoryName + "/issues']"));
		issuesTab.click();
	
		//Thread.sleep(500);
		//WebElement newIssueButton = driver.findElement(By.cssSelector("div.subnav [href='/" + username + "/" + repositoryName + "/issues/new']"));
		WebElement newIssueButton = driver.findElement(By.xpath("//div[@class='subnav']/a[@href='/" + username + "/" + repositoryName + "/issues/new']"));
		newIssueButton.click();
		
		driver.findElement(By.id("issue_title")).sendKeys("This is the issue title");
		driver.findElement(By.id("issue_body")).sendKeys("This is the issue body");
		
		//driver.findElement(By.cssSelector(".timeline-comment button[type='submit'].btn")).click();
		driver.findElement(By.xpath("//div[@class='timeline-comment']//button[contains(text(),'Submit new issue')]")).click();
	}
}
