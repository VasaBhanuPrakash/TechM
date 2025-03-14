package org.bhanu;
import org.junit.Assert.*;
import org.junit.*;
public class TestCalculator {
	Calculator c=new Calculator();
	@Test
	public void TestSum() {
		Assert.assertEquals(5, c.sum(2, 3));
	}
	@Test
	public void TestDiff() {
		Assert.assertEquals(1, c.diff(3, 2));
	}
	@Test
	public void TestProd() {
		Assert.assertEquals(6, c.product(3, 2));
	}
	@Test
	public void testDiff() {
		Assert.assertEquals(1, c.divide(3, 2));
	}
}
