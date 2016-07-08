package pageObjects;



import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsXNav {

	static WebDriver driver;

	   @FindBy(how=How.ID, using="laptops")
	   public static WebElement Laptops;
	   
	   @FindBy(how=How.ID, using="tablets")
	   public static WebElement Tablets;
	   
	   @FindBy(how=How.ID, using="desktops")
	   public static WebElement Desktops;
	   
	  @FindBy(how=How.ID, using="workstations")
	   public static WebElement Workstations;
	   
	   @FindBy(how=How.ID, using="servers")
	   public static WebElement Servers;
	   
	   @FindBy(how=How.ID, using="accessories")
	   public static WebElement Accessories;
	   
	   @FindBy(how=How.ID, using="services")
	   public static WebElement Services;


}
