package week2.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		
		//setup chromedriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//maiximise and open the webpage
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://en-gb.facebook.com/");
		
		//click on create new account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//enter first name
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("selwyn");
		Thread.sleep(2000);
		
		//enter last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("joseph");
		Thread.sleep(2000);
		
		//enter phone number
		driver.findElement(By.name("reg_email__")).sendKeys("9999999999");
		Thread.sleep(2000);
		
		//enter password
		driver.findElement(By.id("password_step_input")).sendKeys("xyzzy123@");
		Thread.sleep(2000);
		
		//select day
		WebElement eleday=driver.findElement(By.id("day"));
		Select dropdown1=new Select(eleday);
		dropdown1.selectByVisibleText("10");
		Thread.sleep(2000);
		
		//select month
		WebElement elemonth=driver.findElement(By.id("month"));
		Select dropdown2=new Select(elemonth);
		dropdown2.selectByIndex(3);
		Thread.sleep(2000);
		
		//select year
		WebElement eleyear=driver.findElement(By.name("birthday_year"));
		Select dropdown3=new Select(eleyear);
		dropdown3.selectByValue("1994");
		Thread.sleep(2000);
		
		//click on radio button male
		driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input")).click();
		Thread.sleep(2000);
		
		//close the browser
		driver.close();
		
		
		
		
		
		

	}

}
