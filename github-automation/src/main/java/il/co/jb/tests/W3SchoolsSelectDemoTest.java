package il.co.jb.tests;

import org.testng.annotations.Test;

import il.co.jb.infra.pages.W3SchoolsTrySelectTagPage;

public class W3SchoolsSelectDemoTest extends AbstractTest {

	@Test
	public void w3SchoolsSelectDemoTest() {
		
		browseToUrl("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
		
		W3SchoolsTrySelectTagPage selectDemoPage = new W3SchoolsTrySelectTagPage(driver);
		selectDemoPage.selectCarMaker("Opel");
	}
}
