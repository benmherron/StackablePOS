package DDT;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
// import multiScreenShot.MultiScreenShot;


public class DemoJenkins {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
  
  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.lenovo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


 /* Workstation Check Tab */ 
  @Test
  public void testworkstation_smoke() throws Exception {
    driver.get(baseUrl + "/us/en/?menu-id=");
    driver.findElement(By.className("product_menu")).click();
    driver.findElement(By.id("workstations")).click();
    Thread.sleep(3000);
   
    try {
      assertEquals("HIGH-PERFORMANCE, RELIABLE WORKSTATIONS", driver.findElement(By.cssSelector("div.hero-productDescription-body > h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }


  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
