package task01;
import java.util.Scanner;

public class AMS {

	public static void main(String[] args) {
		//creating variables
		int account_type_input=0;
		int [] acc=new int [5];
		acc[0]=123;
		acc[1]=456;
		acc[2]=789;
		acc[3]=951;
		String [] Name_arr=new String [5];
		Name_arr[0]="Barry";
		Name_arr[1]="Alex";
		Name_arr[2]="Sophia";
		Name_arr[3]="Parkinson";
		String [] add=new String [5];
		add[0]="Newziland";
		add[1]="Nepal";
		add[2]="Bangladesh";
		add[3]="UAE";
		int [] ph=new int [5];
		ph[0]=1125;
		ph[1]=2279;
		ph[2]=6658;
		ph[3]=6641;
		double [] bal=new double [5];
		bal[0]=60000.0;
		bal[1]=70000.0;
		bal[2]=80000.0;
		bal[3]=100000.0;
		
		int acc_no=123;
		int check=0;
		String Name=Name_arr[0];
		String Address=add[0];
		int ph_no=ph[0];
		double balance=0;
		
		Account user=new Account(Name,Address,ph_no,acc_no,balance);
		Customer obj1=new Customer(Name,Address,ph_no,acc_no);
		
				//System.out.println(user_input.nextLine());
				System.out.println("Press 1. to create a new account ~ ");
				System.out.println("Press 2. to access your account ~ ");
				System.out.println("Press 3. to close your account ~ ");
				Scanner user_input= new Scanner(System.in);
				int choice=user_input.nextInt();
				
				
				int i=obj1.account_no;
				
				switch(choice)
				{
				case 1: {
					// new account
					System.out.println("1. Savings account");
					System.out.println("2. Checking account"); 
					System.out.println("3. Both"); 
					account_type_input=user_input.nextInt();
					user.setAccountType(account_type_input);
					
					//taking user info 
					System.out.println("Enter your Name ~ ");
					Name=user_input.next();
					Name_arr[5]=Name;	//assigning to store in array of new customer
					System.out.println("Enter your Address ~ ");
					Address=user_input.next();
					add[5]=Address;		//assigning to store in array of new customer
					System.out.println("Enter your Phone No. ~ ");
					ph_no=user_input.nextInt();
					ph[5]=ph_no;		//assigning to store in array of new customer
					acc[5]=369;			//assign this for new user
					acc_no=acc[5];
					balance=0;			//initially setting balance to zero
					obj1=new Customer(Name,Address,ph_no,acc_no);
					user=new Account(Name,Address,ph_no,acc_no,balance);
					
				} break;
				case 2: {
					//customer info
					System.out.println("Enter your account number ~ ");
					acc_no = user_input.nextInt();
					for(int x=0;x<5;x++)
					{
						if(acc_no == acc[x])
						{
							check=1;
							Name=Name_arr[x];
							Address=add[x];
							ph_no=ph[x];
							balance=bal[x];
							obj1 = new Customer(Name,Address,ph_no,acc_no);
							user=new Account(Name,Address,ph_no,acc_no,balance);
							break;
						}
						
					}
					if(check != 1 )
					{
							System.out.println("Account doesn't exist!");
					}
				}
				
				case 3:{
					
					System.out.println("Enter your Account PIN to close your account ~ ");
					acc_no=user_input.nextInt();
					for(int j=0;j<5;j++)
					{
						if(acc_no == acc[j])
						{
							Name_arr[j]=null;
							add[j]=null;
							ph[j]=0;
							bal[j]=0;
							acc[j]=0;
							System.out.println("Account deleted successfully!");
							return;
						}
					}
					
				}break;
					default:break;
				}
				
				
				do
				{
				System.out.println("Press...");
				System.out.println("1. Deposite amount ~ ");
				System.out.println("2. Withdraw amount ~ ");
				System.out.println("3. Check Balance ~ ");
				System.out.println("4. Print account statement ~ ");
				System.out.println("5. Transfer amount ~ ");
				System.out.println("6. Calculate Zakat ~ ");
				System.out.println("7. Display all deductions ~ ");
				if(account_type_input==1) {	//saving account
					System.out.println("8. Calculate Interest ~ ");
				}
				
				int acc_input= user_input.nextInt();
				System.out.println();
				
				switch(acc_input)
				{
				case 1: {
					System.out.println("Enter the amount to deposite ~ ");
					double amount_deposite = user_input.nextDouble();
					user.makeDeposite(amount_deposite);
				}break;
				
				case 2:{
					System.out.println("Enter the amount to withdraw ~ ");
					double amt_withdraw=user_input.nextDouble();
					user.makeWithdrawal(amt_withdraw);
				}break;
				
				case 3:{
					
					user.checkBalance(i);	//account number
				}break;
				
				case 4: {
					user.printStatement(i);	//account number
				}break;
				
				case 5:{
					System.out.println("Enter the Account No. to tansfer amount to ~ ");
					int account_transfer_id=user_input.nextInt();
					System.out.println("Enter the amount you want to tranfer ~ ");
					double amount_transfer=user_input.nextDouble();
					user.transferAmount(account_transfer_id,amount_transfer);
					
				}break;
				
				case 6:{
					if(account_type_input==1)
					{
						user.calculateZakat();
					}
					else
					{
						System.out.println("Cannot calculate Zakat on a checking account!");
					}
				}break;
				
				case 7:{
					user.displayAllDeductions(account_type_input);
				}break;
				
				case 8:{
					user.calculateInterest();
				}
				}
				
				System.out.println();
				System.out.println("Do you want to continue? ");
				System.out.println("(Press 1 to continue and Press 2 to exit)");
				check=user_input.nextInt();
				System.out.println();
				
				}while(check==1);
				
				
				
				

	}

}
