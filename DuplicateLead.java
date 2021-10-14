package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		Thread.sleep(2000);
		
		//click on leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		Thread.sleep(2000);
		
		//click on find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		//click on email and enter email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		
		//click on find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		//capture first resulting lead
		WebElement element1=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		String lead1=element1.getText();
		System.out.println(lead1);
		
		//click on the first lead
		element1.click();
		Thread.sleep(2000);
		
		//click on duplicate lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		Thread.sleep(2000);
		
		//verify if duplicate lead is displayed
		if(driver.getTitle().contains("Duplicate Lead"))
		{
			System.out.println("Page is displaying duplicate lead section");
		}
		
		//click on create lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(2000);
		
		//verify if the duplicate lead name is the same 
		WebElement element2=driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
		String duplicatelead=element2.getText();
		Thread.sleep(2000);
		if(duplicatelead.equals(lead1))
		{
			System.out.println("Lead is duplicated and the name is " + duplicatelead);
		}
		
		driver.close();
		
		
		
		
		
		
		
		

	}

}
