package il.co.jb.amazon.auto.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestClass1 extends AbstractTest {

	@Test
	public void test3() {
		report.log("This is from test3");
		Assert.fail("This is a failure");
	}
	
	@Test(priority = 1, dependsOnMethods = {"test3"})
	public void test1() {
		report.log("This is from test1");
	}
	
	@Test
	public void test2() {
		report.log("This is from test2");
	}
}
