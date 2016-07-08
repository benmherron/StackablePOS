package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class LoginPage {
	

	   @FindBy(how=How.ID, using="LoginName")
	   public static WebElement LoginInput;
	   
	   @FindBy(how=How.CLASS_NAME, using="Password")
	   public static WebElement PasswordInput;
	   
	   @FindBy(how=How.CLASS_NAME, using="button-called-out signInForm-submitButton")
	   public static WebElement SignInCTA;
	   
	  @FindBy(how=How.ID, using="RememberMe")
	   public static WebElement RememberCheckBox;
	   
	   @FindBy(how=How.CLASS_NAME, using="button-called-out signInModule-createAccount-button")
	   public static WebElement CreateAccountCTA;
	  

	}


