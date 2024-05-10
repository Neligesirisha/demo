package com.dealsday.screeshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakenScreenShot5 {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.getcalley.com/how-calley-auto-dialer-app-works/");
		TakesScreenshot tss = (TakesScreenshot)driver;
		File temp = tss.getScreenshotAs(OutputType.FILE);
		File perm = new File("./errorShot5/" + timeStamp + "getCallerycallAutoDialer.png");
	    FileUtils.copyFile(temp, perm);
	    driver.manage().window().minimize();
	    driver.quit();
}
}
