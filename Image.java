package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Image.html");
		Thread.sleep(1000);
		
		//click on image
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		Thread.sleep(2000);
		
		//go back to webpage
		driver.findElement(By.xpath("//li[@class='col-lg-3 col-md-3 col-sm-3'][4]/a")).click();
		Thread.sleep(2000);
		
		
		//check if image is broken or not
		driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).click();
		Thread.sleep(1000);
		WebElement title=driver.findElement(By.xpath("//div[@class='wp-page-heading']"));
		String t=title.getText();
		if(t.contains("Interact with Images"))
				{
					System.out.println("second image link is broken");
				}
		else
		{
			System.out.println("All links on the page are working");
		}
		
		//click on image using keyboard
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
		Thread.sleep(1000);
		
		driver.close();
		
		
		

	}

}
