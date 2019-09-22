package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.infra.web.By2;

public class GitHubStartPage extends AbstractPage {

	private static final By2 startProjectButton = new By2("'Start project' button", By.xpath("//div[contains(@class,'shelf-content')]/a[@href='/new']"));
	private static final By2 signedInAsLabel = new By2("'Signed in as...' label", By.cssSelector("strong.css-truncate-target"));
	
	public GitHubStartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickStartProjectButton() {
		bot.click(startProjectButton);
		//driver.findElement(startProjectButton.by).click();
	}
	
	public void clickUserAvatar(String username) {
		By2 userAvatarImage = new By2("", By.xpath("(//img[@alt='@" + username + "'])[2]"));
		
		bot.click(userAvatarImage);
//		report.log("Click: " + userAvatarImage);
//		driver.findElement(userAvatarImage.by).click();
	}
	
	public String getSignedInAsLabel() {
		
		return bot.getElementText(signedInAsLabel);
		
//		WebElement signedInAsElement = driver.findElement(signedInAsLabel.by);
//		String elementText = signedInAsElement.getText();
//		report.log("Element " + signedInAsLabel + " inner text: '" + elementText + "'");
//		return elementText;
	}
}
