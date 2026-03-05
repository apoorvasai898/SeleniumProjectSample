package com.sample.projecttest;

import org.testng.annotations.Test;
		
public class SampleCreateOrgTest {
	@Test(groups = "ST")
	public void createOrg1Test()
	{
		System.out.println("Organization 1");
	}
	
	@Test
	public void createOrg2Test()
	{
		System.out.println("Organization 2");
	}

}
