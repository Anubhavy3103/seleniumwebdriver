package Pratice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); // T
		
		driver.get("https://flipkart.com");
		
		driver.manage().window().maximize();
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		
		File sourcefile =ts.getScreenshotAs(OutputType.FILE);
		
		File targetfile = new File(System.getProperty("user.dir")+"/screenshot/homepage.png");
		
		sourcefile.renameTo(targetfile);
		
		
		
	}

}
