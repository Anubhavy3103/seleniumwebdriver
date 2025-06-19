package TestNg;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderMethod {

		WebDriver driver;
		
		@BeforeClass
		
		void setup() {
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       
		}
		
		@Test(dataProvider="dp")
		void testlogin(String email, String pwss) throws InterruptedException {
			
			driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwss);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
     		Thread.sleep(2000);	
	        boolean status =driver.findElement(By.xpath("//h2[normalize-space(text())='My Account']")).isDisplayed();
			
	        if(status==true) {
		
     		driver.findElement(By.xpath("//a[@class=\"list-group-item\"] [normalize-space(text())='Logout']")).click();
		
	    	Assert.assertTrue(true);
		
                 	}
	        else 
        	{
	         	Assert.fail();
	        }
			
		}
		
		@AfterClass
		void tearDown(){
			
			driver.close();
			
		}
		
		@DataProvider (name="dp")
		Object [][]logindata(){
			
			Object [][] data= {
					
					{"test123@gmail.com","test123@"},
					{"test456@gmail.com","test123@"},
					{"test789@gmail.com","test123@"},
					{"oopp9900@gmail.com","test@123"},
					{"test123@gmail.com","test123@"},
			
		};
			
			return data;
		}
		



   
}