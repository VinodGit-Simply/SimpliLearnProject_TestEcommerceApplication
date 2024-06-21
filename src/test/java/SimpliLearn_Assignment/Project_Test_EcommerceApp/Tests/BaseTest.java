package SimpliLearn_Assignment.Project_Test_EcommerceApp.Tests;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	
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
	
	@AfterTest
	public void Clean_Up()
	{
		driver.quit();
	}

}

/**
Add Selenium commands in the PageLoadTimeout code
• Create a new class to test elements on the e-commerce application's Home page
• The HomePage class should extend the test base class so that we can import method OpenBrowser()
• Create a test method and name it HomePageTest()
• Write steps to perform mouse hover action on menu option Pages
• Write steps to click on Contact in the dropdown list
• Write steps to handle the Alert box that will appear  **/
