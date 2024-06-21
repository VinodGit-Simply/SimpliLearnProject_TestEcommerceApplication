package SimpliLearn_Assignment.Project_Test_EcommerceApp.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	By checkout_text = By.xpath("//div[@class='page-title text-center']/h2");
	
    By First_name = By.id("first_name");
    By Last_Name = By.id("last_name");
    By Company = By.id("company");
    
    By Country_List = By.xpath("//ul[@class='list']/li");
    
    By St_Address1 = By.id("street_address");
    By St_Address2= By.id("street_address2");
    By post_code = By.id("postcode");
    By city = By.id("city");
    By state = By.id("state");
    By number = By.xpath("//input[@type='number']");
    By email = By.xpath("//input[@type='email']");
    By checkbox = By.xpath("//label[text()='Terms and conitions']");
    // By checkbox = By.xpath("//div[@class='custom-control custom-checkbox d-block mb-2'][1]");
    //By checkbox = By.cssSelector("#customCheck1");
    // By checkbox = By.cssSelector("div.custom-control custom-checkbox d-block mb-2[1]");
    //By checkbox = By.cssSelector("lable.custom-control-label");
   // By checkbox = By.cssSelector("lable.custom-control-label::before");
    By place_order = By.xpath("//a[text()='Place Order']");
    
    public WebElement place_order1 ;
    
    public String verify_checkoutpage() throws InterruptedException {
    	Thread.sleep(1000);
    	return driver.findElement(checkout_text).getText();
    	
    }
    
    public void Enter_Billinginfo() throws InterruptedException {
    	
    	driver.findElement(First_name).sendKeys("test");
    	driver.findElement(Last_Name).sendKeys("test");
    	Actions action = new Actions(driver);
    	action.scrollToElement(driver.findElement(Company)).build().perform();
    	driver.findElement(Company).sendKeys("test");
    	Thread.sleep(1000);
    	action.scrollToElement(driver.findElement(Country_List)).build().perform();
    	driver.findElement(By.xpath("//div[@class='col-12 mb-3'][2]")).click();
    	Thread.sleep(3000);
    	//By.xpath("//div[@class='nice-select w-100']")
    	
    	
    	List<WebElement> list = driver.findElements(Country_List);
    	
    	for (WebElement ele : list) {
    		
    		System.out.println("Elemented of Country List : ->" + ele.getText().toString() );
    		if (ele.getText().toString().equalsIgnoreCase("India")) {
    			
    			System.out.println("Country value to be selected : ->" + ele.getText().toString() );
    			//driver.findElement(By.xpath("//ul[@class='list']/li[5]")).click();
    			ele.click();
    			break;		
    		}
    	}
    	Thread.sleep(1000);
    	action.scrollByAmount(100, 250);
    	driver.findElement(St_Address1).sendKeys("test1");
    	driver.findElement(St_Address2).sendKeys("test2");
    	driver.findElement(post_code).sendKeys("000000");
    	action.scrollByAmount(100, 100);
    	driver.findElement(city).sendKeys("test");
    	driver.findElement(state).sendKeys("test");
    	driver.findElement(number).sendKeys("1234567890");
    	driver.findElement(email).sendKeys("test@gmail.com");
    	Thread.sleep(1000);
    	WebElement checkbox1 = driver.findElement(checkbox);
    	System.out.println("is the checkbox element displayed :->" + checkbox1.isDisplayed());
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click",checkbox1);
    	
    	//checkbox1.click();
    	System.out.println("is the checkbox element clickable :->" + checkbox1.isSelected());
    	
    	
    	action.moveToElement(checkbox1).click();
    	Thread.sleep(4000);
    	
    	
    }
    
    public  void placeOrder() throws InterruptedException {
    	
    	place_order1 = driver.findElement(place_order);
    	place_order1.click();
    
    	Thread.sleep(1000);
    }
    
    public String checkOrder() 
    {
    	return place_order1.getText().toString();
    }

}
