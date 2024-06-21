package SimpliLearn_Assignment.StepDefinitions;

import SimpliLearn_Assignment.Project_Test_EcommerceApp.DriverManager.DriverManager;
import SimpliLearn_Assignment.Project_Test_EcommerceApp.Pages.CartPage;
import SimpliLearn_Assignment.Project_Test_EcommerceApp.Pages.CheckoutPage;
import SimpliLearn_Assignment.Project_Test_EcommerceApp.Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TestCartStepDefintion{
	
	public static HomePage hm;
	DriverManager dm = new DriverManager();
	
	public static WebDriver driver ;
	public static CheckoutPage cp;
	
	@Given("The application URL")
	public void OpenApplication() throws InterruptedException {
		
		dm.OPenBrowser();
		driver = dm.driver;
		hm = new HomePage(driver);
	    
		
	}
	
	@And("Navigate to Cart Page")
	
	public void click_cartpage() throws InterruptedException{
		String text_cart = hm.Click_CartButton();
		Thread.sleep(1000);
		Assert.assertEquals("Summary", text_cart);
		
		
	}
	
	@When("Click on CheckOutButton")
	public void click_checkoutbutton() throws InterruptedException {
	       hm.Click_CheckOut();
	}
	
	
	@And("Navigate to Checkout Page")
	public void Navigate_checkoutpage() {
		cp = new CheckoutPage(driver);
	}
	
	@And("Enter Billing Details")
	public void Enter_BillingDetail() throws InterruptedException {
		Thread.sleep(2000);
		cp.Enter_Billinginfo();
	}
	
	@When("Click on PlaceOrder")
	public void Place_Order() throws InterruptedException {
		cp.placeOrder();
	}
	
	@Then("Check whether order is placed")
	public void check_order()
	{
		String order_result = cp.checkOrder();
		Assert.assertEquals("PLACE ORDER",order_result);
	}
	
	@After
    public  void Tear_down(){

        
		System.out.println("Inside After Hooks..");
        driver.quit();
    }
}
