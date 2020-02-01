package Academy;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import alpha.Demo;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	@Test
	public void basePageNavigation() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		//Properties prop;
		driver.get("http://qaclickacademy.com");
		log.info("navigated to HomePage");
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		//l.getPractice().getText().
		//Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Successfully validated the Text");
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	}
	
   
}
