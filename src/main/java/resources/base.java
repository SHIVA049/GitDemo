package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
public static WebDriver driver;
public Properties prop;

public WebDriver initializeDriver() throws IOException
{
	//datadriver.properties
	Properties prop=new Properties();
	//System.getProperty("user.dir"); - Using this to parameterize the path
	//FileInputStream fis= new FileInputStream("C:\\Users\\somne\\E2EProject\\src\\main\\java\\resources\\data.properties");
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
	prop.load(fis);
	
	//mvn test -Dbrowser=chrome
	String browserName=System.getProperty("browser");
	//String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	if (browserName.equals("Firefox"))
	{
		//System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe" - parameterizing path
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
    else if(browserName.equals("chrome"))
    {
    	
    	
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
      //To make the browser headless use below two statements
    	ChromeOptions options=new ChromeOptions();
    	options.addArguments("headless");
        driver=new ChromeDriver(options);
    }
    else if(browserName.equals("IE"))
    {
        driver=new InternetExplorerDriver();
     }
	
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  return driver;
      // driver.get(prop.getProperty("url"));



}

   public void getScreenshot(String result)
   {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  //FileUtils.(src, new File("C:\\Users\\somne\\Test\\"+result+"screenshot.png));
   }

}
