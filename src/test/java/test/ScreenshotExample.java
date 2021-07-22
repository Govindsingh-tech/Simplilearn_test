package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		TakesScreenshot tsobj = (TakesScreenshot) driver;
		
		File screenshotAs = tsobj.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotAs, new File("screenshot.png"));
	}

}
