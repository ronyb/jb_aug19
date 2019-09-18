package il.co.jb.infra.web;

import org.openqa.selenium.WebDriver;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class ActionBot {

	private WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();
	
	public ActionBot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(By2 by2) {
		report.log("Click: " + by2);
		driver.findElement(by2.by).click();
	}
	
	public void writeToElement(By2 by2, String text) {
		report.log("Write '" + text + "' to: " + by2);
		driver.findElement(by2.by).sendKeys(text);
	}
	
	public String getElementText(By2 by2) {
		String text = driver.findElement(by2.by).getText();
		report.log("Element " + by2 + " inner text: '" + text + "'");
		return text;
	}
}
