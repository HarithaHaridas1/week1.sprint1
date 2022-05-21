package sprint1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_050_EditWorkTypeGroup {
	
	public static void main(String[] args) throws InterruptedException {
		
		

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

		//4. Click on the Work Type Group tab
		WebElement tab = driver.findElement(By.xpath("(//a[@class=\"slds-context-bar__label-action dndItem\"])[18]"));
		Actions grpName =new Actions(driver);
		grpName.moveToElement(tab).click().perform();
		Thread.sleep(3000);
		grpName.moveToElement(tab).click().perform();
		
		//5. Search the Work Type Group 'Salesforce Automation by Your Name'
		//driver.findElement( By.xpath("//input[@placeholder=\"Search this list...\"]")).sendKeys("HARITHA HARIDAS");
		WebElement search= driver.findElement(By.xpath("//input[@placeholder=\"Search this list...\"]"));
		search.sendKeys("HARIDAS");
		System.out.println("1st completed");
		Actions enterFun =new Actions(driver);
		enterFun.moveToElement(search).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("2st completed");
	    
		//6. Click on the Dropdown icon and Select Edit
		WebElement editButton =driver.findElement(By.xpath("(//*[@class=\"slds-icon-utility-down slds-button__icon slds-icon_container forceIcon\"]/following :: a)[6]"));
		Actions edit = new Actions(driver);
		edit.moveToElement(editButton).click().perform();
		Thread.sleep(3000);
		edit.click().perform();
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.xpath("(//*[@title =\"Edit\"])[1]"));
		Actions newEdit = new Actions(driver);
		newEdit.moveToElement(button).click().perform();
		Thread.sleep(3000);
		newEdit.click().perform();
		System.out.println("3st completed");
		
		
		
		
		//7.Enter Description as 'Automation'.
		driver.findElement(By.xpath("//*[@class=\" textarea\"]")).sendKeys("Automation");
		
		//8.Select Group Type as 'Capacity'
		WebElement dropdown = driver.findElement(By.xpath("//*[text()='Default']"));
		Actions groups = new Actions(driver);
        groups.moveToElement(dropdown).click().perform();
        WebElement capacity =driver.findElement(By.xpath("//*[@title=\"Capacity\"]"));
        groups.moveToElement(capacity).click().perform();
        
		
		
		//9.Click on Save
        driver.findElement(By.xpath("//*[@class=\"slds-button slds-button--neutral uiButton--brand uiButton forceActionButton\"]")).click();
		//10. Click on 'Salesforce Automation by Your Name'and Verify Description as 'Automation'
		
		
	   // System.out.println("S06_050 TestCase completed successfully");	}

	
	/*Expected Result:
	The Work Type Group is edited Successfully */
        
	}
}
