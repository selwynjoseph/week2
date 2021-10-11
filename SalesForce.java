package week2.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		
		//fill in text fields
		driver.findElement(By.name("UserFirstName")).sendKeys("selwyn");
		Thread.sleep(2000);
		
		driver.findElement(By.name("UserLastName")).sendKeys("joseph");
		Thread.sleep(2000);
		
		driver.findElement(By.name("UserEmail")).sendKeys("selwyn@gmail.com");
		Thread.sleep(2000);
		
		//select job title dropdown
		WebElement eletitle=driver.findElement(By.name("UserTitle"));
		Select dropdown1=new Select(eletitle);
		dropdown1.selectByIndex(1);
		Thread.sleep(2000);
		
		//fill in company name
		driver.findElement(By.name("CompanyName")).sendKeys("accenture");
		Thread.sleep(2000);
		
		//select employee dropdown
		WebElement eleemployee=driver.findElement(By.name("CompanyEmployees"));
		Select dropdown2=new Select(eleemployee);
		dropdown2.selectByValue("75");
		Thread.sleep(2000);
		
		
		
		//select country dropdown
		WebElement elecountry=driver.findElement(By.name("CompanyCountry"));
		Select dropdown3=new Select(elecountry);
		dropdown3.selectByValue("AR");
		Thread.sleep(2000);
		
		//fill in phone number
		driver.findElement(By.name("UserPhone")).sendKeys("9999999999");
		Thread.sleep(2000);
		
		//click the agreement checkbox
		driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div[1]")).click();
		//driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/..")).click();
		Thread.sleep(2000);
		
		
		
		//close the browser
		driver.close();
		
		
		

	}

}
