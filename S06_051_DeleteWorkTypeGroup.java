package sprint1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_051_DeleteWorkTypeGroup {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
            //Test Steps  		
		
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
		Thread.sleep(3000);
	    	//4. Click on the Work Type Group tab 
		WebElement tab = driver.findElement(By.xpath("//*[@class=\"slds-is-unsaved navItem slds-context-bar__item slds-shrink-none slds-is-active\"]"));
		Actions grpName =new Actions(driver);
		grpName.moveToElement(tab).click().perform();
		Thread.sleep(3000);
		grpName.moveToElement(tab).click().perform();
		
	    	//5. Search the Work Type Group 'Salesforce Automation by Your Name'
		WebElement search= driver.findElement(By.xpath("//input[@placeholder=\"Search this list...\"]"));
		search.sendKeys("HARIDAS");
		System.out.println("1st completed");
		Actions enterFun =new Actions(driver);
		enterFun.moveToElement(search).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("2st completed");
		
	     	//6. Click on the Dropdown icon and Select Delete
		WebElement del =driver.findElement(By.xpath("(//*[@class=\"slds-icon-utility-down slds-button__icon slds-icon_container forceIcon\"]/following :: a)[6]"));
		Actions delete = new Actions(driver);
		delete.moveToElement(del).click().perform();
		Thread.sleep(3000);
		delete.click().perform();
		Thread.sleep(3000);
		WebElement dlt = driver.findElement(By.xpath("//*[@class=\"uiMenuItem\"]/following :: a"));
		delete.moveToElement(dlt).click().perform();
		Thread.sleep(3000);
		System.out.println("3st completed");
		
	    	//7.Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//*[@title=\"Delete\"]")).click();
		
	    	//8. Verify Whether Work Type group is Deleted using Work Type Group Name
		
	    	// Expected Result:
			//The Work Type Group is deleted Successfully 
		
		
		
		
		
	}

}
