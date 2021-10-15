package week2.day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		
		//select "selenium" using index
		WebElement element1=driver.findElement(By.id("dropdown1"));
		Select d1=new Select(element1);
		d1.selectByIndex(1);
		Thread.sleep(2000);
		
		//select "appium" using index
		WebElement element2=driver.findElement(By.name("dropdown2"));
		Select d2=new Select(element2);
		d2.selectByVisibleText("Appium");
		Thread.sleep(2000);
		
		//select "UFT/QTP" using value
		WebElement element3=driver.findElement(By.id("dropdown3"));
		Select d3=new Select(element3);
		d3.selectByValue("3");
		Thread.sleep(2000);
		
		//get number of dropdown options
		WebElement element4=driver.findElement(By.className("dropdown"));
		Select d4=new Select(element4);
		List <WebElement> l=d4.getOptions();
		System.out.println("no of options are " + l.size());
		
		
		//using sendkeys
		Thread.sleep(2000);
		WebElement element5=driver.findElement(By.xpath("(//div[@class=\"example\"]/select)[5]"));
		element5.sendKeys("Loadrunner");
		
		/*
		
		//select "selenium" and "appium" at once
		WebElement element6=driver.findElement(By.xpath("(//div[@class=\"example\"]/select)[6]"));
		Select d6=new Select(element6);
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL.click(d6.getOptions().get(2))).click(d6.getOptions().get(1)).keyUp(Keys.CONTROL).build().perform();
		
		*/
		
		

	}

}
