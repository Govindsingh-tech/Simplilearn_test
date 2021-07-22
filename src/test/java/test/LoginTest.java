package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginTest obj = new LoginTest();
		
		obj.Setup();
		obj.Testcase1();
		obj.Cleanup();

	}

	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	public void Testcase1() {
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();

		WebElement Username = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));

		Username.sendKeys("abc@xyz.com");
		Password.sendKeys("Abc123456");
		LoginBtn.click();

		WebElement LoginError = driver.findElement(By.id("msg_box"));

		String ActError = LoginError.getText();
		String ExpError = "The email or password you have entered is invalid.";

		if (ActError.equals(ExpError)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC Failed");
		}

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("total links " + Links.size());

	}

	public void Cleanup() {

		driver.quit();

	}

}
