package org.bhanu;
import junit.framework.*;
import org.junit.Test;
public class CalculatorTest {
	@Test
	public void testSum() {
		Calculator c=new Calculator();
		Assert.assertEquals(5, c.sum(2, 3));
	}
	@Test
	public void testDiff() {
		Calculator c=new Calculator();
		Assert.assertEquals(1, c.diff(3, 2));
	}
	@Test
	public  void testProd() {
		Calculator c=new Calculator();
		Assert.assertEquals(6, c.product(3, 2));
	}
	@Test
	public void testDivide() {
		Calculator c=new Calculator();
		Assert.assertEquals(1, c.divide(3, 2));
	}
}
