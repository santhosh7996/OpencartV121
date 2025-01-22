package testBase;

import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j 
import org.apache.logging.log4j.Logger;// log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class BaseClass
{
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master","datadriven"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		
		//FileReader file= new FileReader("./src//test//resources//config.properties"); //alternative of the FileInputStream class
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os");
				return;
				
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge":   capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default:System.out.println("Invalid browser name..");return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
				case"chrome":driver=new ChromeDriver();break;
				case"firefox":driver=new FirefoxDriver();break;
				case"edge":driver=new EdgeDriver();break;
				default:System.out.println("Invalid browser name..");return;
			}
		}
		
		
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl")); //reading url from properties file
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Sanity","Regression","Master","datadriven"})
	public void teardown() throws InterruptedException
	{
		
		driver.quit();     
	}
	
	
	public String randomString()
	{
		String generatedstring= RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	
	public String randomeNumber()
	{
		String generatednumber= RandomStringUtils.randomNumeric(10);
		return generatednumber;

	}
	
	public String randomAlphaNumeric()
	{
		
		String generatedstring= RandomStringUtils.randomAlphabetic(7);
		String generatednumber= RandomStringUtils.randomNumeric(10);
		return(generatedstring+"@"+generatednumber);
	}
	
	public  String captureScreen(String tname)  throws IOException
	{
		// TODO Auto-generated method stub
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourcefile =  takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" +tname+"_"+timeStamp+".png";
		File targetfile =new File(targetFilePath);
		sourcefile.renameTo(targetfile);
		return targetFilePath;
		
	}


}
