package il.co.jb.amazon.auto.tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.jb.amazon.auto.infra.config.MainConfig;
import il.co.jb.amazon.auto.infra.pages.AddedToCartPage;
import il.co.jb.amazon.auto.infra.pages.AmazonLandingPage;
import il.co.jb.amazon.auto.infra.pages.AmazonProductPage;
import il.co.jb.amazon.auto.infra.pages.AmazonSearchResultsPage;
import il.co.jb.amazon.auto.infra.utils.AssertUtils;

public class _002_ShoppingCartTest extends AbstractTest {

	private String searchTerm;
	
	@Test
	public void _002_shoppingCart() throws Exception {
		
		initTestParams();
		
		// Step 1 - Browse to amazon.com landing page
		report.startLevel("Step 1 - Browse to amazon.com landing page");
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		amazonLandingPage.setDeliverToUsZipCode("12345");
		report.endLevel();
		
		// Step 2 - Write a random search term in the top search bar and click the search button
		report.startLevel("Step 2 - Write a random search term in the top search bar");
		amazonLandingPage.writeToSearchbox(searchTerm);
		AmazonSearchResultsPage amazonSearchResultsPage = amazonLandingPage.clickOnGoButton();
		report.endLevel();
		
		// Step 3 - Click the title of the first item in the list of search results
		report.startLevel("Step 3 - Click the title of the first item");
		AmazonProductPage amazonProductPage = amazonSearchResultsPage.clickOnSearchResultTitleByIndex(4);
		report.endLevel();
		
		// Step 4 - Click "Add to Cart" button
		report.startLevel("Step 4 - Click \"Add to Cart\" button");
		AddedToCartPage addedToCartPage = amazonProductPage.clickAddToCartButton();
		report.endLevel();
		
		// Step 5 - Verify the "Cart" icon on the top right of the page shows the correct number of products added to the cart.
		report.startLevel("Step 5 - Verify the \"Cart\" icon");
		AssertUtils.assertEquals(addedToCartPage.getCartCounterValue(), 1, "Number of items in cart should be 1");
		report.endLevel();
	}
	
	private void initTestParams() throws Exception {
	
		Properties prop = new Properties();
		InputStream input = new FileInputStream("src/main/resources/config/_085_shoppingCartTest.properties");

		prop.load(input);

		searchTerm = prop.getProperty("searchTerm");
	}
}
