package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.amazon.auto.infra.web.By2;

public class AmazonProductPage extends AbstractPage {

	private static final By2 addToCartButton = new By2("'Add to cart' button", By.id("add-to-cart-button"));
	private static final By2 productTitle = new By2("Product title", By.id("productTitle"));
	private static final By2 addToOrderPopupXButton = new By2("Popup 'X' button", By.cssSelector("button[data-action='a-popover-close']"));
	
	public AmazonProductPage(WebDriver driver) throws Exception {
		super(driver, addToCartButton, productTitle);
	}
	
	public AddedToCartPage clickAddToCartButton() throws Exception {
		
		bot.click(addToCartButton);
		Thread.sleep(500);
		
		if (bot.isElementDisplayed1(addToOrderPopupXButton)) {
			bot.click(addToOrderPopupXButton);
		}
		
		return new AddedToCartPage(driver);
	}
	
	public void clickAddToOrderPopupXButton() {
		bot.click(addToOrderPopupXButton);
	}
}
