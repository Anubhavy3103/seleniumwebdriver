package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class paramtestng {

		WebDriver driver;
		
		@BeforeClass
		@Parameters({"browser"})
		void setup(String br) throws InterruptedException {
			
			switch(br) {
			case "chrome" :driver =new ChromeDriver(); break;
			case "safari" : driver = new SafariDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			
			default : System.out.println("Invalid Browser"); return;
			
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver.manage().window().maximize();
			
			Thread.sleep(3000);
			
		}

		@Test(priority=1)
		void testlogo() {
			
			boolean status =driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		
			AssertJUnit.assertEquals(status, true);
		}
		@Test(priority=2)
		void testtitle() {
			
		AssertJUnit.assertEquals(driver.getTitle(),"OrangeHRM");
			
		}
		@Test(priority=3)
		void testurl() {
			
			AssertJUnit.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
		
		@AfterClass
		void teardown() {
			
				driver.close();
	    
		}
		
	

}
