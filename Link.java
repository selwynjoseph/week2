package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Link.html");
		Thread.sleep(1000);
		
		//go to home page and then come back to links page
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		driver.navigate().back();
		Thread.sleep(1000);
		
		//button 
		System.out.println(driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));

		//verify if link is broken
		driver.findElement(By.linkText("Verify am I broken?")).click();
		Thread.sleep(1000);
		if(driver.getTitle().equals("HTTP Status 404 – Not Found"))
		{
			System.out.println("Broken");
		}
		driver.navigate().back();
		
		
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		Thread.sleep(1000);
		
		driver.close();
		
	}

}
