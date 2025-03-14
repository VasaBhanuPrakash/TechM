package org.bhanu;
import org.junit.*;
public class JunitTest {
	@Test
	public void testSum() {
		Sum s=new Sum();
		Assert.assertEquals(5, s.SumTest(2, 3));
	}
	@Ignore("Skipping due a known reason")
	@Test
	public void testSum1() {
		Sum s= new Sum();
		Assert.assertEquals(6, s.SumTest(3, 3));
	}
}
