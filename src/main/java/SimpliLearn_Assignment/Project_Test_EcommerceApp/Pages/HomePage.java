package SimpliLearn_Assignment.Project_Test_EcommerceApp.Pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	 public  WebDriver driver;
	 public String verify_text ;
	 
	 Actions actions ;
	 
      public HomePage(WebDriver driver) {
    	  
    	  System.out.println("driver session value in HOMEPAGE :"+driver);
    	  this.driver = driver;
    	  actions = new Actions(driver);
    	  PageFactory.initElements(driver, this);
    	  System.out.println("driver session value in HOMEPAGE :"+this.driver);
      }
      
      
      public @FindBy (xpath="//li[@class='cn-dropdown-item has-down pr12']/a[contains(text(),'Pages')]")
      
       WebElement Pages;
      
      public @FindBy (css="a[href^='contact']") WebElement Contact;
      //public @FindBy (partialLinkText="contact@") WebElement contact_email;
      public WebElement contact_email;
      
      public @FindBy (css=".cart-area") WebElement Cart;
      public WebElement Summary;
      //By checkout_element = By.linkText("checkout");
     public  By checkout_element = By.xpath("//a[text()='check out']");
      
      public String MenuPage_Test() throws InterruptedException {
    	  Thread.sleep(2000);
    	  
    	  actions.moveToElement(Pages).build().perform();
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    	  actions.moveToElement(Contact).click().perform();
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    	  contact_email = driver.findElement(By.partialLinkText("contact@"));
    	  actions.scrollToElement(contact_email).build().perform();
    	  Thread.sleep(2000);
    	  
    	   verify_text = contact_email.getText();
    	   System.out.println("verify text :" + verify_text);
    	  
    	  return verify_text;
    	  
      }
      
      
      public String Click_CartButton() throws InterruptedException {
    	  
    	  System.out.println("IS cart button displayed .. ? :" + Cart.isDisplayed());
    	  Thread.sleep(1000);
    	  Cart.click();
    	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
    	  
    	  Summary = driver.findElement(By.xpath("//div[@class='cart-amount-summary']/h2"));
    	 
    	  Thread.sleep(5000);
    	  // actions.scrollToElement(Summary).build().perform();
    	  System.out.println("value of the Summary Weblement text is --> "+Summary.getText());
    	  return Summary.getText();
      }
      
      public void Click_CheckOut() throws InterruptedException {
    	  
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    	 actions.scrollToElement(driver.findElement(checkout_element)).build().perform();
    	 Thread.sleep(1000);
    	  driver.findElement(checkout_element).click();
      }
}
