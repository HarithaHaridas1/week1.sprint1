package sprint1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_049_CreateWorkTypeGroup {
	
public static void main(String[] args) {
	
	
	//Download the Chrome Driver and Set the path
	WebDriverManager.chromedriver().setup();
	
   // Handle Notification
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	// Test Steps:
	   
	ChromeDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	 //1. Login to https://login.salesforce.com
	
	driver.get("https://login.salesforce.com");
	driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
	driver.findElement(By.id("Login")).click();
	
	
	//2. Click on the toggle menu button from the left corner
	driver.findElement(By.className("slds-icon-waffle")).click();
	
	//3. Click View All and click Work Type Groups from App Launcher
	driver.findElement(By.xpath("//button[@class=\"slds-button\"]")).click();
	driver.findElement(By.xpath("//input[@placeholder=\"Search apps or items...\"]")).sendKeys("Work Type Groups");
	driver.findElement(By.xpath("//mark[text() = 'Work Type Groups']")).click();
	
	 //4.Click on the Dropdown icon in the Work Type Groups tab 
     driver.findElement(By.xpath("(//a[@title='Work Type Groups']//following::lightning-primitive-icon)[1]")).click();
	
	 //5. Click on New Work Type Group
     WebElement newWorkType = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
     driver.executeScript("arguments[0].click();", newWorkType); 
	
     
	 //6. Enter Work Type Group Name as 'Salesforce Automation by Your Name'
	driver.findElement(By.xpath("//input[@class=\" input\"]")).sendKeys("Salesforce Automation by Apple");
	
	//7. Click save and verify Work Type Group Name
	driver.findElement(By.xpath("//button[@title=\"Save\"]")).click();
	
	
	WebElement groupName = driver.findElement(By.partialLinkText("Salesforce Automation"));
	String S = groupName.getText();
	System.out.println(S);
	
	
    System.out.println("S06_049 Testcase completed sucessfully");
	
	
}	
	

}


