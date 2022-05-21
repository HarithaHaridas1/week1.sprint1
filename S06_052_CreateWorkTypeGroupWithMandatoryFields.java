package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_052_CreateWorkTypeGroupWithMandatoryFields {
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

	
	//4. Click on the Dropdown icon in the Work Type Groups tab
	WebElement tab = driver.findElement(By.xpath("(//*[@class =\"slds-icon-utility-chevrondown slds-icon_container\"])[14]"));
	Actions grpName =new Actions(driver);
	grpName.moveToElement(tab).click().perform();
	Thread.sleep(3000);
	grpName.moveToElement(tab).click().perform();
	
	//5. Click on New Work Type Group
	 WebElement newWorkType = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
     driver.executeScript("arguments[0].click();", newWorkType); 
	
	//7.Enter Description as 'Automation'.
	driver.findElement(By.xpath("//*[@class=\" textarea\"]")).sendKeys("Automation");
	
	//8.Select Group Type as 'Capacity'
	WebElement group = driver.findElement(By.xpath("//*[@class=\"select\"]"));
	Actions capacity = new Actions(driver);
	capacity.moveToElement(group).click().perform();
	WebElement cap = driver.findElement(By.xpath("//*[@title =\"Capacity\"]"));
	capacity.moveToElement(cap).click().perform();
	
	//9. Click on Save
	driver.findElement(By.xpath("//*[@class =\"slds-button slds-button--neutral uiButton--brand uiButton forceActionButton\"]")).click();
	
	//10. Verify the Alert message (Complete this field) displayed for Work Type Group Name
	//Expected Result:
	//Complete this field message should be displayed for Work Type Group Name field
	
	
	
	
}
}
