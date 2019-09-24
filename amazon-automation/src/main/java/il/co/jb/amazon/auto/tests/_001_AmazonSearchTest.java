package il.co.jb.amazon.auto.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.jb.amazon.auto.infra.pages.AmazonLandingPage;
import il.co.jb.amazon.auto.infra.pages.AmazonSearchResultsPage;

public class _001_AmazonSearchTest extends AbstractTest {

	@Test
	public void _001_amazonSearch() throws Exception {
		
		String searchTerm = "Samsung";
		String expectedWordInFisrtResult = "Galaxy";
		
		driver.get("http://amazon.com");
		
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		amazonLandingPage.writeToSearchbox(searchTerm);
		
		AmazonSearchResultsPage amazonSearchResultsPage = amazonLandingPage.clickOnGoButton();
		
		String firstNonSponsoredResultTitle = amazonSearchResultsPage.getFirstNonSponsoredResultTitle();
		
		Assert.assertTrue(firstNonSponsoredResultTitle.contains(expectedWordInFisrtResult), "The first result doesn't contain '" + expectedWordInFisrtResult + "'");
	}
}
