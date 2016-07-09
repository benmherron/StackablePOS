package DDT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelDataConfig;

public class StackableCheckPOS 
{
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
		@Test(dataProvider="StackablePartCheck")
		public void stackableScript(String warrantyCode, String addonCodeList) throws InterruptedException
		{		
	
		System.out.println("****************************************************************************************");
		System.out.println("****************************************************************************************");
		System.out.println("$$$$$$$$$$$$$$$$$$$          "+ warrantyCode + " Testing" + "       $$$$$$$$$$$$$$$$$$$$");
		System.out.println("****************************************************************************************");
		System.out.println("****************************************************************************************");
		
		System.out.println(warrantyCode);
		System.out.println(addonCodeList);
			
			
		//Start Test//	
		System.out.println("");	
		
		driver=new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Launch Browser
        driver.get("http://ctdev.leni2.com/us/en/laptops/thinkpad/t-series/t560/");	 
        
        //Navigate to Warranties
		driver.findElement(By.id("view-customize")).click();	
		driver.findElement(By.xpath("//div[@id='tab-customize']/div[2]/div[2]/ol/li/div[3]/div[3]/div/a")).click();
		driver.findElement(By.cssSelector("#WARRANTY > span")).click();		
		Thread.sleep(3000);
		System.out.println("1");	
		//Test 1 Begin //
		driver.findElement(By.cssSelector("." + warrantyCode + " label")).click();
		Thread.sleep(3000);
		
		System.out.println("2");
			
	//	driver.findElement(By.xpath("//input[@class='O4Y']")).click();	
		System.out.println("");
		System.out.println("...mapping webparts to excel parts...");
		System.out.println("");
	    String addOns = addonCodeList;	  
	    String[] items = addOns.split(",");	    	  
	    List<String> itemList = Arrays.asList(items);	 
	    List<WebElement> myList=driver.findElements(By.cssSelector("#warrServices .stackableHeader a  span"));
	    List<String> stackablePartList=new ArrayList<>();	    	    
	    for(int i=0; i<myList.size(); i++)
	    {	
	    	String str = myList.get(i).getText();
	    	str = str.substring(str.lastIndexOf(' ') + 1);  
	    	stackablePartList.add(str + "3");
	    	if(itemList.contains(str)) {
	    		System.out.println("Match Found for Web Part Number: " + str);	
	    	}else{
	    		System.out.println("No Match Found for Web Part Number: " + str);	    		    		
	    	}
	    }
	    
	    //Test 2 Begin //
	    System.out.println("");
	    System.out.println("...mapping excel parts to webparts...");
	    System.out.println("");
	    
	    for(int i=0; i<itemList.size(); i++)
	    {	
	    	String str = itemList.get(i);
//	    	System.out.println(str);		      
//	    	System.out.println("After substring: " + str);
	    	if(stackablePartList.contains(str)) {
	    		System.out.println("Match Found for Spreadsheet Part Number: " + str);	
	    	}else{
	    		System.out.println("No Match Found for Spreadsheet Part Number: " + str);

	    		    		
	    	}
	    }
    
	    System.out.println("");
	    System.out.println("Web list:  " + stackablePartList);
	    System.out.println("Item list: " + itemList);
	    System.out.println("");
	    System.out.println("");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX             "+"-END-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		System.out.println("...kicking off next warranty code...");

		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
			
    	@DataProvider(name="StackablePartCheck")
		public Object[][] passData()
		{
			//File Location//
			ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\bherron\\ExcelData\\stackablePhase1.xlsx");	
						
			//Capture Entire Worksheet Rows
			int rows=config.getRowCount(0);
			
			//Create Array One ([rows][int columns])//
			Object[][] data=new Object[rows][2];						
			int count=0;
			for(int i=0;i<rows;i++)
			{	
				String str = config.getData(0, i, 5);
			//	System.out.println("string before if: " + str);
				if (str.length() > 0 && ! str.equals("Applicability") && config.getData(0, i, 3).equals("TP Mainstream")) {
			//	System.out.println("string after if: " + str);	
				//(sheet,row,column)
					data[count][0]=config.getData(0, i, 0);
				//	System.out.println(config.getData(0, i, 0));			
					data[count][1]=str;
				//	System.out.println(config.getData(0, i, 3));			
					count = count+1;					
				}	
			}
			
			//Remove Duplicates//
			String WarrantyCodes="";	
			for(int i=0;i<count;i++)
			{	
				if (i==0) {	
				WarrantyCodes=WarrantyCodes+data[i][1];
				}
				if (i>0)  {		
				WarrantyCodes=WarrantyCodes+","+data[i][1];
				}	
			}
	
			String deDupWarrantyCodes = deDup(WarrantyCodes);
			deDupWarrantyCodes = deDupWarrantyCodes.replace("[", "");
			deDupWarrantyCodes = deDupWarrantyCodes.replace("]", "");
			deDupWarrantyCodes = deDupWarrantyCodes.replace(" ", "");
						
			//System.out.println(deDupWarrantyCodes.split(","));
			
			//Capture Array Length//
			int warrantyCodeLength = deDupWarrantyCodes.split(",").length;			
			Object [] warrantyCodePhase1 = deDupWarrantyCodes.split(",");
			Object [][] warrantyCodePhase2  = new Object[warrantyCodeLength][2];

			for(int i=0;i<warrantyCodeLength;i++)
			{	
		//			System.out.println(warrantyCodePhase1[i]);
					warrantyCodePhase2[i][0] = warrantyCodePhase1[i];
					warrantyCodePhase2[i][1] = addonCodes(count, warrantyCodePhase1[i], data);		
			}	
			return warrantyCodePhase2;	
		}
    	   	
    	public String deDup(String s) {
		return new LinkedHashSet<Object>(Arrays.asList(s.split(","))).toString();
		}
    	public String addonCodes(int count, Object warrantyCode, Object[][] data) {
    		String codes = "";
			for(int i=0;i<count;i++)
			{
				//addoncode is in data[i][0]
				//warrantyCode is in data[i][1]
				if (((String) data[i][1]).contains((String)warrantyCode)) {
					if (codes == "")
					  codes = codes + data[i][0];
				    else
					  codes = codes + "," + data[i][0];
				}				
			};
			return codes;
		}
    	
}