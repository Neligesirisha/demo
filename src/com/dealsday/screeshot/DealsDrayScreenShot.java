package com.dealsday.screeshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DealsDrayScreenShot
{
	public static void main(String[] args) throws InterruptedException, IOException
	{	
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	    driver.get("https://demo.dealsdray.com/");
	    driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
	    driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
	    driver.findElement(By.xpath("//button[text()='Login']")).click();
	    driver.findElement(By.xpath("//span[text()='Order']")).click();
	    driver.findElement(By.xpath("//span[text()='Orders']")).click();
	    driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
	    driver.findElement(By.xpath("//input[contains(@class,'MuiOutlinedInput-input MuiInputBase')]")).sendKeys("C:\\Users\\palla\\Downloads\\demo-data.xlsx");
        driver.findElement(By.xpath("//button[text()='Import']")).click();
        driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Actions action = new Actions(driver);
        WebElement scrollElement = driver.findElement(By.id("mui-461"));
        action.scrollToElement(scrollElement).perform();
        TakesScreenshot tss = (TakesScreenshot)driver;
        File temp = tss.getScreenshotAs(OutputType.FILE);
        File perm = new File("./ScreenShot/" + timeStamp + "misPannell.png");
        FileUtils.copyFile(temp, perm);
        driver.manage().window().minimize();
        driver.quit();
	}
}
