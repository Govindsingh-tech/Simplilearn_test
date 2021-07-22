package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement CreateAccount = driver.findElement(By.xpath("//*[text()='Create New Account']"));
		
		CreateAccount.click();
		
		WebElement Date = driver.findElement(By.xpath("//*[@id='day']"));
		WebElement Month = driver.findElement(By.xpath("//*[@id='month']"));
		WebElement Year = driver.findElement(By.xpath("//*[@id='year']"));
		Select MonthDropDown = new Select(Month);
		Select DateDropDown = new Select(Date);
		Select YearDropDown = new Select(Year);
		
		DateDropDown.selectByVisibleText("10");
		MonthDropDown.selectByVisibleText("Oct");
		YearDropDown.selectByVisibleText("2000");
		//MonthDropDown.selectByValue("1");
		//MonthDropDown.selectByIndex(1);
		
		WebElement Gender = driver.findElement(By.xpath("//*[@type='radio' and @value='2']"));
		Gender.click();
		
		
	}
}
