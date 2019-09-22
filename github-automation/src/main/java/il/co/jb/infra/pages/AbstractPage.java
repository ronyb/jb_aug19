package il.co.jb.infra.pages;

import org.openqa.selenium.WebDriver;

import il.co.jb.infra.web.ActionBot;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public abstract class AbstractPage {

	protected WebDriver driver;
	protected ActionBot bot;
	
	protected ReportDispatcher report = ReportManager.getInstance();
	
	public AbstractPage(WebDriver driver) {
		report.log("*** Current page: " + this.getClass().getSimpleName());
		this.driver = driver;
		this.bot = new ActionBot(driver);
	}
}
