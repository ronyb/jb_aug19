package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.amazon.auto.infra.web.By2;

public class AddedToCartPage extends AbstractPage {

	private static final By2 addedToCartTitle = new By2("'Added to cart' title", By.xpath("//h1[contains(text(),'Added to Cart')]"));
	private static final By2 cartCounterSpan = new By2("Cart counter", By.id("nav-cart-count"));
	
	public AddedToCartPage(WebDriver driver) throws Exception {
		super(driver, addedToCartTitle, cartCounterSpan);
	}
	
	public int getCartCounterValue() {
		
		String cartCounterText = bot.getElementText(cartCounterSpan);
		int cartCounter = Integer.parseInt(cartCounterText);
		return cartCounter;
	}
}
