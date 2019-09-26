package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.amazon.auto.infra.web.By2;

public class AmazonLandingPage extends AbstractPage {

	private static final By2 searchBox = new By2("Main search box", By.id("twotabsearchtextbox"));
	private static final By2 goButton = new By2("'Go' button", By.xpath("//input[@value='Go']"));
	private static final By2 signInSecurlyButtonBy = new By2("'Sign-in securly' button", By.id("a-autoid-0-announce"));
	private static final By2 amazonMusicLink = new By2("'Amazon Music' link", By.xpath("//a[text()='Amazon Music']"));
	private static final By2 deliverToButton = new By2("'Deliver to' button", By.xpath("//a[.//span[text()='Deliver to']]"));
	private static final By2 usZipCodeInput = new By2("'US zip code' input", By.id("GLUXZipUpdateInput"));
	private static final By2 usZipCodeApplyButton = new By2("'US zip code - Apply' button", By.cssSelector("[aria-labelledby='GLUXZipUpdate-announce']"));
	private static final By2 deliveryToContinueButton = new By2("'Delivery to - Continue' button", By.xpath("(//input[@id='GLUXConfirmClose'])[2]"));
	
	public AmazonLandingPage(WebDriver driver) throws Exception {
		super(driver, searchBox, goButton);
	}
	
	public void writeToSearchbox(String searchTerm) {
		bot.writeToElement(searchBox, searchTerm);
	}
	
	public AmazonSearchResultsPage clickOnGoButton() throws Exception {
		bot.click(goButton);
		return new AmazonSearchResultsPage(driver);
	}
	
	public void WaitForSignInSecurlyButtonEnabled() {
		bot.waitForElementToBeClickable(signInSecurlyButtonBy);
	}
	
	public void setDeliverToUsZipCode(String zipCode) throws Exception {
		bot.click(deliverToButton);
		bot.writeToElement(usZipCodeInput, zipCode);
		bot.click(usZipCodeApplyButton);
		bot.click(deliveryToContinueButton);
		Thread.sleep(2000);
	}
	
	public void clickAmazonMusicLink() {
		bot.click(amazonMusicLink);
	}
}
