package TestNGExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListner.class)
public class LoginTest {
	WebDriver driver;

	//XSSFWorkbook wbook;
	//XSSFSheet sheet;

	@BeforeMethod
	public void Setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		//FileInputStream fis = new FileInputStream("exceldata.xlsx");

		//wbook = new XSSFWorkbook(fis);

		//sheet = wbook.getSheet("data");
	}

	@Test
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

//		if (ActError.equals(ExpError)) {
//			System.out.println("TC Passed");
//		} else {
//			System.out.println("TC Failed");
//		}

		// Assertion Method
		Assert.assertEquals(ActError, ExpError);

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("total links " + Links.size());

	}

	@AfterMethod
	public void Cleanup() {

		driver.quit();

	}

}
