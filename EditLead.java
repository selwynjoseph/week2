package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {

			//setup chrome driver
				WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver=new ChromeDriver();
				
				//launch url and login
				driver.get("http://leaftaps.com/opentaps/control/main");
				
				driver.manage().window().maximize();
				
				Thread.sleep(2000);
				
				driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
				
				//Thread.sleep(2000);
				
				driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
				
				Thread.sleep(2000);
				
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//Thread.sleep(2000);
				
				
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				Thread.sleep(2000);
				
				//click on leads
				driver.findElement(By.xpath("//a[text()='Leads']")).click();
				Thread.sleep(2000);
				
				//click on find leads
				driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
				Thread.sleep(2000);
				
				
				//enter first name
				driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("test1");
				Thread.sleep(2000);
				
				
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				Thread.sleep(2000);
				
				
				WebElement element1=driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']/div/a"));
				String name=element1.getText();
				
				element1.click();
				
				if(driver.getTitle().contains("View Lead"));
				{
					System.out.println("Lead page verified");
				}
				//click on edit
				driver.findElement(By.xpath("//a[text()='Edit']")).click();
				Thread.sleep(2000);
				
				//change company name
				driver.findElement(By.id("updateLeadForm_companyName")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TESTLEAF");
				
				
				//click on update
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				Thread.sleep(2000);
				
				//verify the updated name 
				WebElement element2=driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
				String updatedname = element2.getText();
				System.out.println("updated company name is " + updatedname);
					

				driver.close();
	
	

	}

}
