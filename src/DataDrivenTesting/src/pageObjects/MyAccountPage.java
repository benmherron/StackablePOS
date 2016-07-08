package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	   @FindBy(how=How.CLASS_NAME, using="fbox")
	   public static WebElement SignOut;
	  
	  
	}