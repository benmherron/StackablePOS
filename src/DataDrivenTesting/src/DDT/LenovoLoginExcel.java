package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelDataConfig;




public class LenovoLoginExcel 
{

	WebDriver driver;
	
		@Test(dataProvider="SignInData")
		public void loginToWordpress(String sUserName, String sPassword) throws InterruptedException
		{
			
			
			
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://shop.lenovo.com/SEUILibrary/controller/e/web/LenovoPortal/en_US/account.workflow:StartMyAccount?shopping-menu-selected-line=cart&menu-id=account");
			driver.findElement(By.id("LoginName")).sendKeys(sUserName);
			driver.findElement(By.id("Password")).sendKeys(sPassword);
			driver.findElement(By.className("button-called-out signInModule-createAccount-button")).click();
			
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("Dashboard"), "User is not able to login- Invalid Credentials");		
			System.out.println("Page Title verified- User is able to login Successfully");
			
		}
				
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
			
		@DataProvider(name="SignInData")
		public Object[][] passData()
		{
			
			ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\bherron\\selenium\\DataDrivenTesting\\TestData\\InputData.xlsx");
			
			int rows=config.getRowCount(0);
				
			
			//create array (3 rows, 2 columns)
			Object[][] data=new Object[rows][2];
			
			for(int i=0;i<rows;i++)
			{
				
				data[i][0]=config.getData(0, i, 0);
				data[i][1]=config.getData(0, i, 0);
				
			}

			
			return data;
		
		}	
	
}
