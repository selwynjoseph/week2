package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		
		//click on find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		////click on phone tab
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//enter phone number and click on find leads
		driver.findElement(By.name("phoneNumber")).sendKeys("9999911111");
		
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		//capture first lead result
		WebElement lead=driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']"));
		System.out.println(lead.getText());
		String leadvalue=lead.getText();
		Thread.sleep(2000);
		
		//click on first lead result
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a[1]")).click();
		Thread.sleep(2000);
		
		//click on delete button
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(2000);
		
		//click find leads again
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		
		//enter previously captured lead id in lead id field and search
		driver.findElement(By.name("id")).sendKeys(leadvalue);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		//verify if records are found or not
		WebElement verifydisplay=driver.findElement(By.xpath("//div[text()='No records to display']"));
		String display=verifydisplay.getText();
		Thread.sleep(3000);
		
		if(display.contains("No records to display"))
		{
			System.out.println("Successful record deletion confirmed");
		}
		
		driver.close();

	}

}
