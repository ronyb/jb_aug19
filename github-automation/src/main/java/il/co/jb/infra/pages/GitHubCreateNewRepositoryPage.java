package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubCreateNewRepositoryPage extends AbstractPage {

	private static final By repositoryNameInput = By.id("repository_name");
	private static final By repositoryDescriptionInput = By.id("repository_description");
	private static final By repositoryVisibilityPrivateRadioButton = By.id("repository_visibility_private");
	private static final By createRepositoryButton = By.xpath("//div[@class='js-with-permission-fields']/button[@type='submit']");
	
	public GitHubCreateNewRepositoryPage(WebDriver driver) {
		super(driver);
	}
	
	public void writeRepositoryName(String repositoryName) {
		driver.findElement(repositoryNameInput).sendKeys(repositoryName);
	}
	
	public void writeRepositoryDescription(String repositoryDescription) {
		driver.findElement(repositoryDescriptionInput).sendKeys(repositoryDescription);
	}
	
	public void clickRepositoryVisibilityPrivateRadioButton() {
		driver.findElement(repositoryVisibilityPrivateRadioButton).click();
	}
	
	public void clickCreateRepositoryButton() {
		driver.findElement(createRepositoryButton).click();
	}
}
