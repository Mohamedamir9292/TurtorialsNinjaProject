package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class BaseClass {
	
	// this class is the parent for all test case classes and it contains all the methods that are commonly used in test classes
	
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Sanity", "Regression", "Master"})
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) throws IOException {
		p = new Properties();
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p.load(file);
		logger = LogManager.getLogger(this.getClass());
		
		
		// os
		if(p.getProperty("execution_env").equals("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("ther's no matching operating system");
				return;
			}
			
		// browser
		
			switch(br.toLowerCase()) {
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			default: System.out.println("No matching browser name"); return;
			}
			
		}
		
		if(p.getProperty("execution_env").equals("local")) {
		
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid Browser name..");
				return;

			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		 
	}
	// the following 3 methods will automatically generate a random string that can be used to set email, name, telephone or password dynamically 
	
	public String randomString() {
		String randString = RandomStringUtils.randomAlphabetic(5);
		return randString;
	}
	
	public String randomNumber() {
		String randNum = RandomStringUtils.randomNumeric(10);
		return randNum;
	}
	
	public String randomPassword() {
		String randPassword = RandomStringUtils.randomAlphanumeric(10);
		return randPassword;
	}
	
	// tear down method
	
	@AfterClass(groups = {"Sanity", "Regression", "Master"})
	public void tearDown() {
		driver.close();
	}
	
	// method to capture screenshot for failing test cases it returns a String for the file path where the screenshot is saved.
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		
		
		return targetFilePath;
	}


}
