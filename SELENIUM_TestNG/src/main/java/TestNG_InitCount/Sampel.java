package TestNG_InitCount;

import org.testng.annotations.Test;

public class Sampel 
{
	@Test(invocationCount = 5)
	public void invocationcount()
	{
		
		System.out.println("Hello Count ");
		
	}

}
