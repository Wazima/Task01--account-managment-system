package task01;

import java.util.Calendar;

public class Account extends Customer{

private
	double balance;
	double withdraw;
	double deposite;
	double transfer_amount;
	double zakat;
	Customer n = new Customer(name,address,phone_no,account_no);
	//double tax;
	int Account_Type;	//1. savings   2. current
	int transfer_check=0;	//initializing it with zero
	int additional_transaction_charges=10;
	Calendar c;	//to get time and date
	double interest;
	double bal[]= {70000,60000,800000,500000};
	
	
public

	Account() {
	
}

 Account(String name, String address, int phone_no, int account_no, double balance) {
	super(name, address, phone_no, account_no);
	
}

	

	void setAccountType(int type) {
	Account_Type=type;
}
	

	void checkBalance(int account_no) {
		n.print_name();
		System.out.println(balance);
		System.out.println("Current balance : " + balance);
	}
	
	public double getbalance(int index) {
		balance=bal[index];
		return bal[index];
	}
	
	public Boolean makeWithdrawal(double withdraw_amount) {
		withdraw=withdraw_amount;
		if(Account_Type== 2)	//2. checking account
		{
			transfer_check++;
			if(transfer_check > 2)
			{
				System.out.println("You already made 2 transactions in one month!");
				System.out.println("You will have to pay additional charges of Rs.10 with each transaction!");
				withdraw_amount+=additional_transaction_charges;
			}
			
		}
		if(Account_Type == 1)	//1. savings account
		{
			if (withdraw_amount > balance)
			{
				System.out.println("You cannot transfer more than your balance = " + balance);
			}
		}
		
		if ((withdraw_amount < 5000))
			{
				balance=balance-withdraw_amount;
			}
		
		if(withdraw_amount > getbalance(0))
		{
			return false;
		}
		else return true;
	}
	
	public void printStatement(int account_no) {
				
		System.out.println("Customer info...");
		
		n.print_name();
		n.print_address();
		n.print_phoneno();
		n.print_Accountno();
		System.out.println("Time of Transaction ~ ");
		System.out.format("%tl:%tM %tp%n",c,c,c);
		System.out.println("Date of Transaction ~ ");
		System.out.format("%tB %te,%tY%n",c,c,c);
		System.out.println("Transacted amount ~ " + transfer_amount);
		if(transfer_check > 2)
		{
			System.out.println("Total Additional Transaction Charges ~ " + additional_transaction_charges);
		}
		System.out.println("Remaining Balance ~ " + balance);
		
		
	}
	
	public void makeDeposite(double amount_dep) {
		
		if(Account_Type== 2)	//2. checking account
		{
			transfer_check++;
			if(transfer_check > 2)
			{
				System.out.println("You already made 2 transactions in one month!");
				System.out.println("You will have to pay additional charges of Rs.10 with each transaction!");
				amount_dep+=additional_transaction_charges;
			}
			
		}
		
		deposite=amount_dep;
		balance=balance+amount_dep;
		//setbalance(balance);
		
	}
	
	public Boolean transferAmount(int id,double trans_amount) {
		
		if(Account_Type== 2)	//2. checking account
		{
			transfer_check++;
			if(transfer_check > 2)
			{
				System.out.println("You already made 2 transactions in one month!");
				System.out.println("You will have to pay additional charges of Rs.10 with each transaction!");
				trans_amount+=additional_transaction_charges;
			}
			
		}
		
		transfer_amount=trans_amount;
		balance=balance-trans_amount;
		c= Calendar.getInstance();
		
		if(id==n.getacc(1))
		{
			return true;
		}
		else return false;
	}
	
	public double calculateZakat(double amount) {	//only for savings account
		
		if(balance>20000)
		{
			zakat=(balance*2.5)/100;
			balance=balance-zakat;
		//	System.out.println("Zakat Deducted ~ " + zakat);
			
		}
		else {
			System.out.println("Zakat can only be calculated on Current Balance more than 20,000.");
		}
		
		return zakat;
	}
	
	public void calculateInterest() {		//calculating for per year
		interest=balance/100;
		interest=interest/12;		//calculating for per year
	}
	
	public void displayAllDeductions(int check_account_type)
	{
		n.print_name();
		n.print_Accountno();
		System.out.println();
		
		if(check_account_type == 1 )	//savings account
		{
			System.out.println("Savings account...");
			System.out.println("Zakat Deduction ~ " + zakat ); 	
		}
		else if(check_account_type == 2)	//checking account
		{
			System.out.println("Checking account...");
			//System.out.println("Tax deduction ~ " + tax);
			
		}
			System.out.println("Withdrawal Deduction ~ " + withdraw);
			System.out.println("Transfer Deducton ~ " + transfer_amount);
		
	}
	

}
