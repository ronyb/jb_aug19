package il.co.jb.amazon.auto.tests;

import java.io.File;

import org.testng.annotations.Test;

import il.co.jb.amazon.auto.infra.utils.AssertUtils;

public class AssertExamples extends AbstractTest {

	@Test
	public void assertExampleTest1() {
		AssertUtils.assertEquals(3, 3, "ints should be equal");
		report.log("This is after the assert...");
	}
	
	@Test
	public void assertExampleTest2() {
		File f = new File("C:\\Users\\jbt\\Desktop\\tt1.txt");
		AssertUtils.assertTrue(f.exists(), "File should exist");
		report.log("This is after the assert...");
	}
}
