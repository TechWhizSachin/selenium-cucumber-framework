package Hooks;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class Hooks {
	
	private TestContext context;
	WebDriver driver;
	ConfigReader cr=new ConfigReader();
	private ExtentReports extent;
    private ExtentTest test;
	
	public Hooks(TestContext context) {
		this.context=context;
		extent = ExtentManager.getInstance();
	}
	
	@Before
	public void setup(Scenario scenario) {
		
		test = extent.createTest(scenario.getName());
        ExtentTestManager.setTest(test);
		
		if(cr.getBrowser().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			context.setDriver(driver);
		}
		
		else if(cr.getBrowser().equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			}
		
		else if(cr.getBrowser().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			}
		
		else if(cr.getBrowser().equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver();
			driver =new SafariDriver();
			}
		context.setDriver(driver);
		driver.get(cr.getUrl());
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("Test Failed");
        } else {
            ExtentTestManager.getTest().pass("Test Passed");
        }

        extent.flush();
        
        if (scenario.isFailed()) {
            String path = takeScreenshot(driver, scenario.getName());

            ExtentTestManager.getTest().fail("Failed",
                MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
		
		driver.quit();
	}
	
	public String takeScreenshot(WebDriver driver, String name) {
	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String path = "reports/" + name + ".png";
	        FileUtils.copyFile(src, new File(path));
	        return path;
	    } catch (Exception e) {
	        return null;
	    }
	}
	
}
