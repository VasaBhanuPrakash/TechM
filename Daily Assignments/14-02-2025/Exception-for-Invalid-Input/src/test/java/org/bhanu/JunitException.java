package org.bhanu;
import org.junit.*;
public class JunitException {
	@Test
	public void JunitException() throws InvalidException{
		ExceptionforInvalidInput i=new ExceptionforInvalidInput();
		Assert.assertEquals(15, i.returnValue(15));
	}
	@Test(expected=InvalidException.class)
	public void testInvalid() throws InvalidException{
		ExceptionforInvalidInput i=new ExceptionforInvalidInput();
		i.returnValue(5);
	}
}
