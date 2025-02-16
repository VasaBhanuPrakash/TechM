package org.bhanu;
import org.junit.*;
public class JunitClass {
	@Test
	public void returnValue() {
		MainClass m=new MainClass();
		Assert.assertEquals(5, m.returnValue(5));
	}
}
