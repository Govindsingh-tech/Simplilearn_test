package TestNGExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside after method");
	}
}
