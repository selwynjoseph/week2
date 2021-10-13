package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Button.html");
		
		
		//position of button
		System.out.println("Position is " + driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation());

		
		//get colour
		WebElement color=driver.findElement(By.id("color"));
		System.out.println("color is " + color.getCssValue("background-color"));
		
		//get dimensions
		WebElement size=driver.findElement(By.id("size"));
		System.out.println("Size is " + size.getSize());
		
		
		//click and go to homepage
		driver.findElement(By.id("home")).click();
		
		driver.close();
				
		
	}

}
