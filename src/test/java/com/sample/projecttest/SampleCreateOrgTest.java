package com.sample.projecttest;

import org.testng.annotations.Test;
		
public class SampleCreateOrgTest {
	@Test(groups = "RT")
	public void createOrg1Test()
	{
		System.out.println("Organization 1");
	}
	
	@Test(groups = "RT")
	public void createOrg2Test()
	{
		System.out.println("Organization 2");
	}
	
	@Test(groups = "RT")
	public void createOrg3Test()
	{
		System.out.println("Organization 3 ===============================");
	}

}
