package il.co.jb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubStartPage extends AbstractPage {

	private static final By startProjectButton = By.xpath("//div[contains(@class,'shelf-content')]/a[@href='/new']");
	
	public GitHubStartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickStartProjectButton() {
		driver.findElement(startProjectButton).click();
	}
}
