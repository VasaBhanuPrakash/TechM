package org.bhanu;
import org.junit.*;
public class JunitTest {
	@Test
	public void SquareTest() {
		Square s=new Square();
		Assert.assertEquals(8, s.cube(2));
	}
}
