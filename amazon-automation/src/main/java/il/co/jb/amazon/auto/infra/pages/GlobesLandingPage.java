package il.co.jb.amazon.auto.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.amazon.auto.infra.web.By2;

public class GlobesLandingPage extends AbstractPage {

	private static final By2 portalMenuHeader = new By2("'Financial Portal' Menu Heading", By.id("GH_2"));
	private static final By2 portfolioMenuLink = new By2("'Portfolio' Menu Link", By.cssSelector("div.folderWrap li > a[href='/portfolio/']"));
	
	public GlobesLandingPage(WebDriver driver) throws Exception {
		super(driver, portalMenuHeader);
	}
	
	public void hoverOverPortalMenuHeader() {
		bot.hoverOverElement(portalMenuHeader);
	}

	public void clickPortfolioMenuLink() {
		bot.hoverOverElement(portalMenuHeader);
		bot.click(portfolioMenuLink);
	}
}
