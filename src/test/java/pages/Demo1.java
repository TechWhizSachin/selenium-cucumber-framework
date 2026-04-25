package pages;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Demo1 {

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");	
	}

}
