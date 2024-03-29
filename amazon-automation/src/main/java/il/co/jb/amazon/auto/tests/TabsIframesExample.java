package il.co.jb.amazon.auto.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import il.co.jb.amazon.auto.infra.web.TabAndIframeUtils;

public class TabsIframesExample extends AbstractTest {

	@Test
	public void iframeTest() {

		browseToUrl("file:///C:/Users/jbt/Desktop/iframe_tabs/page1.html");

		TabAndIframeUtils.switchToIframe(driver, By.id("main_iframe"));
		
		driver.findElement(By.id("p3_link")).click();
	}

	@Test
	public void tabsTest() throws Exception {

		browseToUrl("file:///C:/Users/jbt/Desktop/iframe_tabs/page1.html");

		driver.findElement(By.xpath("//a[@href='page2.html']")).click();

		TabAndIframeUtils.switchToTabByUrl(driver, "page2.html");
		
		driver.findElement(By.id("p3_link")).click();
	}
}