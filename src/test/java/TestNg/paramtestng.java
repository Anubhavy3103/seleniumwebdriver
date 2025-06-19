package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class paramtestng {

		WebDriver driver;
		
		@BeforeClass
		void setup() throws InterruptedException {
			
			driver =new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver.manage().window().maximize();
			
			Thread.sleep(3000);
			
			
		}

		@Test(priority=1)
		void testlogo() {
			
			boolean status =driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		
			Assert.assertEquals(status, true);
		}
		@Test(priority=2)
		void testtitle() {
			
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
			
		}
		@Test(priority=3)
		void testurl() {
			
			Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
		
		@AfterClass
	  void teardown() {
		
			
			driver.close();
	     }
		
	

}
