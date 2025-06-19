package Pratice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartitemcheckoutpractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
	WebElement searchbox = 	driver.findElement(By.className("Pke_EE"));
		
		
		searchbox.sendKeys("iphon16");
		searchbox.submit();
		
		
		driver.findElement(By.className("KzDlHZ")).click();
		
		String mainWindow = driver.getWindowHandle();
		Set<String> window  = driver.getWindowHandles();
		
		for(String handels : window) {
			
			if(!handels.equals(mainWindow)) {
				driver.switchTo().window(handels);
				
				break;
			}
		}
		Thread.sleep(3000);
		
		driver.findElement(By.className("QqFHMw vslbG+ In9uk2")).click();
		
		
	}

}
