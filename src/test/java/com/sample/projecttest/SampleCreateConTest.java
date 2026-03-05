package com.sample.projecttest;

import org.testng.annotations.Test;

public class SampleCreateConTest {
	@Test(groups="ST")
	public void createContact1Test()
	{
		System.out.println("Contact 1");
	}
	
	@Test(groups="RT")
	public void createContact2Test()
	{
		System.out.println("Contact 2");
	}

}
