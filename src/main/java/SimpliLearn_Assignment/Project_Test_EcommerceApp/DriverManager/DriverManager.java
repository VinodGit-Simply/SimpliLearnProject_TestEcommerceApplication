package SimpliLearn_Assignment.Project_Test_EcommerceApp.DriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public static WebDriver driver;
	
	public void OPenBrowser() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions Chromeoption = new ChromeOptions();
     
      Chromeoption.addArguments("--start-maximized");
      Chromeoption.addArguments("disable-infobars");
    
	   driver = new ChromeDriver(Chromeoption);
	   
	   driver.get("http://localhost:80");
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	   driver.manage().deleteAllCookies();
	   
	   
	}
}
