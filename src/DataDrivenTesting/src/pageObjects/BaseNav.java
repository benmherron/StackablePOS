package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseNav {
	
WebDriver driver;
	
	   @FindBy(how=How.CLASS_NAME, using="product_menu")
	   public static WebElement Products;
	   
	   @FindBy(how=How.CLASS_NAME, using="deals_menu")
	   public static WebElement Deals;
	   
	   @FindBy(how=How.CLASS_NAME, using="support_menu")
	   public static WebElement Support;
	   
	  @FindBy(how=How.CLASS_NAME, using="phone_menu")
	   public static WebElement Phone;
	   
	   @FindBy(how=How.CLASS_NAME, using="email_menu")
	   public static WebElement Email;
	   
	   @FindBy(how=How.CLASS_NAME, using="solutions_menu")
	   public static WebElement Solutions;
	   
	   @FindBy(how=How.CLASS_NAME, using="community_menu")
	   public static WebElement Community;

	   @FindBy(how=How.CLASS_NAME, using="myaccount_menu")
	   public static WebElement MyAccount;
	   
	   @FindBy(how=How.CLASS_NAME, using="cart_menu")
	   public static WebElement Cart;
	   
	   @FindBy(how=How.CLASS_NAME, using="search_menu")
	   public static WebElement Search;
	   


	}
