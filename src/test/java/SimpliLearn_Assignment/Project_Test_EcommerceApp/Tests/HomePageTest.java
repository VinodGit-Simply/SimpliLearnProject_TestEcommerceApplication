package SimpliLearn_Assignment.Project_Test_EcommerceApp.Tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import SimpliLearn_Assignment.Project_Test_EcommerceApp.Pages.HomePage;

public class HomePageTest extends BaseTest{

	
	
	
	@Test
	public void HomePage_Test() throws InterruptedException {
		
		System.out.println("driver session value :"+driver);
		
		OPenBrowser();
		HomePage hm = new HomePage(driver);
		Thread.sleep(5000);
		hm.MenuPage_Test();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Assert.assertTrue(hm.contact_email.isDisplayed());
		Assert.assertEquals("contact@essence.com", hm.verify_text);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
}
