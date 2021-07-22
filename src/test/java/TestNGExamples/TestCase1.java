package TestNGExamples;

import org.testng.annotations.Test;

public class TestCase1 extends BaseClass{

	@Test
	public void LoanTest() {
		System.out.println("Inside Loan Test");
	}

	@Test
	public void CreditCardtest() {
		System.out.println("Inside CC Test");
	}

}
