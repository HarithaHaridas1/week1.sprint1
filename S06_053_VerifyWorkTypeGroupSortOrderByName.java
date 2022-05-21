package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_053_VerifyWorkTypeGroupSortOrderByName {
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

	
		//4. Click on the Work Type Group tab 
	WebElement tab = driver.findElement(By.xpath("(//a[@class=\"slds-context-bar__label-action dndItem\"])[18]"));
	Actions grpName =new Actions(driver);
	grpName.moveToElement(tab).click().perform();
	Thread.sleep(3000);
	grpName.moveToElement(tab).click().perform();
	
		//5. Click the sort arrow in the Work Type Group Name
	WebElement sort = driver.findElement(By.xpath("(//*[@class=\"toggle slds-th__action slds-text-link--reset \"])[1]"));
	Actions Ascend = new Actions(driver);
	Ascend.moveToElement(sort).click().perform();
		//6. Verify the Work Type Group displayed in ascending order by Work Type Group Name.
		//Expected Result:
		//Work Type Group Should be displayed in ascending order by Work Type Group Name.
	
	
	
	
	
	
}
}
