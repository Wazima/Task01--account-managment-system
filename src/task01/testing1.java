package task01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
 
class testing1 {

	
//	@Before
	//positive test case for account number from customer class
	@Test
	void testPrint_Accountno() {
		System.out.println("Testing pin of customer positive test case");
		Customer testing=new Customer();
		int account_number[]= {123,456,789};
		int output=testing.getacc(0);
		assertEquals(account_number[0],output);
		
	}
	
	
	//negative test case for account number from customer class
	@Test
	void testPrint_Accountno2() {
		System.out.println("Testing pin of customer negative test case");
		Customer testing=new Customer();
		int account_number2[]= {122,456,789};
		int output=testing.getacc(0);
		assertEquals(account_number2[0],output);
		
	}
	
	//@After
	@Test
	void testing_balance() {
		System.out.println("Testing balance of customer positive test case");
		Account testing_acc=new Account();
		double account_bal[]= {70000,60000,80000,10000};
		double output_acc=testing_acc.getbalance(0);
		assertEquals(account_bal[0],output_acc);
	}
	
	@Test
	void testing_balance2() {
		System.out.println("Testing balance of customer negative test case");
		Account testing_acc=new Account();
		double account_bal[]= {90000,10000,810000,18000};
		double output_acc=testing_acc.getbalance(0);
		assertEquals(account_bal[0],output_acc);
	}
	
	
	
	@Test
	void testing_trasfer() {
		System.out.println("Testing transfer amount of customer positive test case");
		Account testing_acc=new Account();
		Boolean output_acc_trans=testing_acc.transferAmount(456,100.0);	//sending the transfer amount and checking on the basis of right id input
		assertEquals(true,output_acc_trans);
	}
	
	@Test
	void testing_trasfer2() {
		System.out.println("Testing transfer amount of customer negative test case");
		Account testing_acc=new Account();
		Boolean output_acc_trans=testing_acc.transferAmount(666,100.0);	//sending the transfer amount and checking on the basis of right id input. account 666 doensn't exist so test case won't work
		assertEquals(true,output_acc_trans);
	}
	
	@Test
	void testing_zakatCalculation() {
		System.out.println("Testing Zakat calculation of customer positive test case");
		Account testing_acc=new Account();
		double output_acc_zc=testing_acc.calculateZakat(testing_acc.getbalance(2));	//giving the balance of the account indexed at 2 i.e. 800000
		assertEquals(20000.0,output_acc_zc);
	}
	
	@Test
	void testing_zakatCalculation2() {
		System.out.println("Testing Zakat calculation of customer negative test case");
		Account testing_acc=new Account();
		double output_acc_zc=testing_acc.calculateZakat(testing_acc.getbalance(0));	//giving the balance of the account indexed at 0 i.e. 70000
		assertEquals(1375,output_acc_zc);	//zakat calculation is incorrect
	}
	
	
	@Test
	void testing_AmountWithdraw() {
		System.out.println("Testing Withdraw Amount of customer positive test case");
		Account testing_acc=new Account();
		Boolean output_acc_wa=testing_acc.makeWithdrawal(200);	//giving the balance of the account indexed at 0 i.e. 70000
		assertEquals(true,output_acc_wa);	//true if the withdraw amount is less than balance
	}
	
	@Test
	void testing_AmountWithdraw2() {
		System.out.println("Testing Withdraw Amount of customer negative test case");
		Account testing_acc=new Account();
		Boolean output_acc_wa=testing_acc.makeWithdrawal(800000);	//giving the balance of the account indexed at 0 i.e. 70000
		assertEquals(true,output_acc_wa);	//true if the withdraw amount is less than balance
	}

}
