package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		driver=initializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		System.out.println(text);
		//lp.getSubmit().click();
		log.info("logged into HomePage");
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
   @DataProvider
   public Object[][] getData()
   {
	   //Row stands for how many different data types test should run
	   //coloumn stands for how many values per each test
	   
	   Object[][] data = new Object[2][3];
	   //0th row
	   data[0][0]="nonrestricteduser@qw.com";
	   data[0][1]="123456";
	   data[0][2]="Restricted User";
	   
	   //1st Row
	   data[1][0]="restricteduser@qw.com";
	   data[1][1]="45678";
	   data[1][2]="Non Restricted User";
	   
	   return data;
			   
   }
    
}
