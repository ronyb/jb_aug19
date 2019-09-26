package il.co.jb.infra.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class ActionBot {

	private WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();
	
	public ActionBot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getElements(By2 by2) {
	}
	
	public void click(By2 by2) {
		report.log("Click: " + by2);
		waitForElementToBeClickable(by2, 5);
		driver.findElement(by2.by).click();
	}
	
	public void writeToElement(By2 by2, String text) {
		report.log("Write '" + text + "' to: " + by2);
		WebElement element = driver.findElement(by2.by);
		element.clear();
		element.sendKeys(text);
	}
	
	public String getElementText(By2 by2) {
		String text = driver.findElement(by2.by).getText();
		report.log("Element " + by2 + " inner text: '" + text + "'");
		return text;
	}
	
	public void selectByText(By2 by2, String text) {
		WebElement selectElement = driver.findElement(by2.by);
		Select select = new Select(selectElement);
		select.selectByVisibleText(text);
	}
	
	public void waitForElementNotDisplayed(By2 by2) {
		WebElement element = driver.findElement(by2.by);
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementToBeClickable(By2 by2, int timeoutInSeconds) {
		WebElement element = driver.findElement(by2.by);
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchToIframeById(String iframeId) {
		driver.switchTo().frame(iframeId);
	}
}
