package il.co.jb;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

	@Test
	public void calculatorAddTest() throws Exception {
		
		int val1 = 5;
		int val2 = 2;
		
		int actualResult = Calculator.add(val1, val2);
		int expectedResult = val1 + val2;
		
		Assert.assertEquals(actualResult, expectedResult, val1 + "+" + val2 + "=" + expectedResult);
		
		/*
		if (actualResult == expectedResult) {
			System.out.println("actual = expected = " + expectedResult + " - OK");
		}
		else {
			throw new Exception("Expected result was: " + expectedResult + ", but actual = " + actualResult);
		}
		*/
	}
}
