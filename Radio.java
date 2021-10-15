package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radio {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		Thread.sleep(1000);
		
		//click on "yes"
		driver.findElement(By.xpath("//*[@id='first']/label[1]")).click();
		Thread.sleep(1000);
		
		//find which value is selected by default
		WebElement element1=driver.findElement(By.xpath("//label[@for='Checked']/input"));
		if(element1.isSelected())
		{
			System.out.println("Checked option is selected");
		}
		else
		{
			System.out.println("Unchecked option is selected");
		}
		Thread.sleep(1000);
		
		//
		WebElement option1=driver.findElement(By.xpath("//label[@for='java']/following-sibling::input[1]"));
		WebElement option2=driver.findElement(By.xpath("//label[@for='java']/following-sibling::input[2]"));
		WebElement option3=driver.findElement(By.xpath("//label[@for='java']/following-sibling::input[3]"));
		
		if(option1.isSelected()|option2.isSelected()|option3.isSelected())
		{
			System.out.println("One of the options is already selected");
		}
		
		else
		{
			option1.click();
		}

		driver.close();
	}

}
