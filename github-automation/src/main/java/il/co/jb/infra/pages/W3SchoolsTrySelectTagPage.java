package il.co.jb.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.jb.infra.web.By2;

public class W3SchoolsTrySelectTagPage extends AbstractPage {

	private static final By2 carMakerSelect = new By2("'Car maker' drop down menu", By.tagName("select"));
	
	public W3SchoolsTrySelectTagPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectCarMaker(String carMaker) {
		bot.switchToIframeById("iframeResult");
		bot.selectByText(carMakerSelect, carMaker);
	}
}
