package Academy;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	@Test
	public void basePageNavigation() throws IOException
	{
		driver=initializeDriver();
		//Properties prop;
		driver.get("http://qaclickacademy.com");
		LandingPage l=new LandingPage(driver);
		//Assert.assertEquals(l.getTitle().getText(), "Featured Courses123");
		//l.getPractice().getText().
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
	     log.info("Navigation bar is displayed correctly");
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	
   
}
