package il.co.jb.amazon.auto.tests;

import org.testng.annotations.Test;

public class ScreenshotTest extends AbstractTest {

	@Test
	public void screenshotTest() throws Exception {
		
		browseToUrl("http://www.google.com");
		takeScreenshot("Testing...");
	}
}
