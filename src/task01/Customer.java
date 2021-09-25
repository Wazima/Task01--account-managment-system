package task01;

public class Customer {

		String name;
		String address;
		int phone_no;
		int account_no;
		int acc[]= {123,456,789,951};

		public Customer() {
			
			
			
		}
		
		
		public Customer(String name, String address, int phone_no, int account_no) {
			super();
			this.name = name;
			this.address = address;
			this.phone_no = phone_no;
			this.account_no = account_no;
		}
		
		

		public void print_name()
		{
			System.out.println("Name ~ "+ name);
		}

		public void print_address()
		{
			System.out.println("Address ~ "+ address);
		}
		
		public void print_phoneno()
		{
			System.out.println("Phone No. ~ " + phone_no);
		}
		
		public void print_Accountno()
		{
			System.out.println("Account No. ~ " + account_no);
		}

		public String get_name(String nam)
		{
			return name=nam;
		}
		
		public int getacc(int index) {
			   
				return acc[index];
		}

}
