package org.bhanu;
import org.junit.*;
public class TimeSpecification {
	@Test
	public void TestSum() {
		AfterSpecifiedTime a=new AfterSpecifiedTime();
		Assert.assertEquals(5,a.sum(2, 3));
	}
	@Test(timeout=1000)
	public void timeWithinSec() {
		fun();
	}
	void fun() {
		try {
			Thread.sleep(900);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
