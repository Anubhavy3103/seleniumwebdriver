package Pratice;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class handelbrokenlinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
           List <WebElement> links =driver.findElements(By.tagName("a"));
	
	      System.out.println("total link size: " + links.size());
	      
	      int noofbrokenlinks = 0;
	      
	      for(WebElement linkElement:links) {
	    	  
	    	  String hrefattribute = linkElement.getAttribute("href");
	    	  
	    	  if(hrefattribute == null || hrefattribute.isEmpty()) {
	    		  
	    		  System.out.println("hrefattribute is null so not possible to cheeck");
	    		  continue;
	    	  }
	    	  
	    try {
	    	 URL linkurl = new URL(hrefattribute);
	    	 
	    	 HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection();
	    	 
	    	 conn.connect();
	    	 
	    	 if(conn.getResponseCode()>=400) {
	    		 
	    		 System.out.println(hrefattribute + "===> link is a broken link");
	    		 
	    		 noofbrokenlinks++;
	    		 
	    	                                  }
	    	 else {
	    		 System.out.println(hrefattribute + "===> Not a broken link");
	    	      }
	          }
	      
	      catch(Exception e) {
	    	  
	          }
	    }
	      System.out.println("Total no of broken links: "+ noofbrokenlinks);
	      
      }
}
