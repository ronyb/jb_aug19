package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.amazon.auto.infra.web.By2;

public class AmazonSearchResultsPage extends AbstractPage {

	private static final By2 firstNonSponsoredResultTitle = new By2("First product title", By.xpath("//div[@data-index='2']//h2"));
	
	public AmazonSearchResultsPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public String getFirstNonSponsoredResultTitle() {
		return bot.getElementText(firstNonSponsoredResultTitle);
	}
	
	public AmazonProductPage clickOnSearchResultTitleByIndex(int resultIndex) throws Exception {
		
		By2 resultTitle = new By2("Title of search result #" + resultIndex, By.xpath("//div[@data-index='" + resultIndex + "']//h2"));
		bot.click(resultTitle);
		return new AmazonProductPage(driver);
	}
	
	public String getSearchResultTitleByIndex(int resultIndex) throws Exception {
		
		By2 resultTitle = new By2("Title of search result #" + resultIndex, By.xpath("//div[@data-index='" + resultIndex + "']//h2"));
		return bot.getElementText(resultTitle);
	}
}
