package org.bhanu;
public class ExceptionforInvalidInput{
	public int returnValue(int x)  throws InvalidException{
		if(x>10) {
			return x;
		}
		else {
			throw new InvalidException("The value"+x+" is invalid");
		}
	}
}
