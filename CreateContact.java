package week2.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//login
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		
		//create contact and fill in all the details
		
		driver.findElement(By.xpath("//a[contains(text(),'Create Contact')]")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("abc");
		//Thread.sleep(2000);
		
		driver.findElement(By.id("lastNameField")).sendKeys("xyz");
		//Thread.sleep(2000);
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("abc1");
		//Thread.sleep(2000);
		
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("xyz1");
		//Thread.sleep(2000);
		
		driver.findElement(By.name("departmentName")).sendKeys("accounts");
		//Thread.sleep(2000);
		
		driver.findElement(By.id("createContactForm_description")).sendKeys("accounts department is fun");
		//Thread.sleep(2000);
		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");
		//Thread.sleep(2000);
		
		
		//select state 
		WebElement elestate=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropdown1=new Select(elestate);
		dropdown1.selectByVisibleText("New York");
		Thread.sleep(4000);
		
		//click on create contact
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(2000);
		
		//click on edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(2000);
		
		//clear description field
		driver.findElement(By.id("updateContactForm_description")).clear();
		Thread.sleep(2000);
		
		//fill important note field
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("updated");
		Thread.sleep(2000);
		
		//click update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);
		
		
		//get title of page
		System.out.print(driver.getTitle());
		
		driver.close();
		
		
		
		
		
		

	}

}
