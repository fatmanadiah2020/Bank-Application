/*
 * Ahmed Matoussi, Alex Van Ess, Adam Jeanquart
 * ahmedgeek1@gmail.com, advaness29@gmail.com, adamjeanquart@gmail.com
 * Bank application week 2
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create accounts
		Account account1 = new Account(12345, 11111, 1000);
		Account account2 = new Account(14789, 22222, 2000);
		Account account3 = new Account(12369, 33333, 30000);

		// Create customers using accounts
		Customer customer1 = new Customer(account1, "Alex");
		Customer customer2 = new Customer(account2, "Ahmed");
		Customer customer3 = new Customer(account3, "Bob");
		
		// Creating cash dispenser for ATM
		CashDispenser cashdispenser1 = new CashDispenser(10000); 
		
		// Create atm
		ATM atm1 = new ATM(cashdispenser1);
		
		// Adding customers to ATM
		atm1.customers.add(customer1);
		atm1.customers.add(customer2);
		atm1.customers.add(customer3);
		
		// Open scanner for user input
	     Scanner sc = new Scanner(System.in);
	     
	     // boolean to check if atm is on
	     boolean atmOn=true;
	     
	     while(atmOn){
	    	 int accountNumber = 0;
		     // Get account number for sign in
	    	 System.out.println("Please enter an account Number!");

		     boolean correctInput = true;
		     
		     // Validate input
		     while(correctInput){
			     if(sc.hasNextInt()){
			    	 accountNumber = sc.nextInt();
			    	 correctInput = false;
			     }else{
				     System.out.println("Please enter a valid account Number!");
				     sc.next();
			     }
		     }
		     
		     // Get and validate pin entry from user
		     int pin = 0;
		     correctInput = true;
		     System.out.println("Please enter a pin to your account!");
		     while(correctInput){
			     if(sc.hasNextInt()){
			    	 pin = sc.nextInt();
			    	 correctInput = false;
			     }else{
				     System.out.println("Please enter a valid pin to your account!");
				     sc.next();
			     }
		     }
		     
		     // call sign in method, bool "true" is returned if pin and account number match
		     boolean session = atm1.SignIn(accountNumber, pin, atm1.customers);
		     // While customer is logged in
		     while(session){
			     // Set active customer for session
		    	 Customer activeCustomer = null;
		    	 
		    	 for(int i=0; i<atm1.customers.size();i++){
		    		 
		 			Customer cust = atm1.customers.get(i);

		 			if(cust.CustomerAccount.getAccountNumber() == accountNumber && cust.CustomerAccount.getPin() == pin){
		 				 activeCustomer = atm1.customers.get(i);
		 			}
		    	 }
		    	 
		    	 // bools for while loops
		    	 boolean exit = true;
		    	 boolean withdraw = false;
		    	 
		    	 // While user has not exited out of session
		    	 while(exit){
			    	 // Main menu prompt
		    		 System.out.println("Please choose an option by entering a number\n balance inquiry (1)\n withdrawal (2)\n deposit (3)\n exit (4)\n");
			    	 int optionentry = 0;
				     
			    	 // Validate user entry 
				     correctInput = true;
				     while(correctInput){
					     if(sc.hasNextInt()){
					    	 optionentry = sc.nextInt();
					    	 correctInput = false;
					     }else{
						     System.out.println("Please choose a valid option by entering a number\n balance inquiry (1)\n withdrawal (2)\n deposit (3)\n exit (4)\n");
						     sc.next();
					     }

				     }
				     	// If user selects 1, show balance
			    		 if(optionentry==1){
				    		 activeCustomer.CustomerAccount.showBalance();
				    		 exit=true;
				    	 }else if(optionentry==2){
				    		 // if user selects 2, perform withdrawal
				    		 withdraw = false;
				    		while(withdraw == false){ 
				    			
				    		// get amount to withdraw	
				    		 System.out.println("Please select an amount to withdraw:\n $20 (1)\n $40 (2)\n $60 (3)\n $100 (4)\n $200 (5) \n Cancel Transaction (6) \n");
				    		 int optionentry2 = 0;
				    		 
				    		 // validate entry
						     correctInput = true;
						     while(correctInput){
							     if(sc.hasNextInt()){
							    	 optionentry2 = sc.nextInt();
							    	 correctInput = false;
							     }else{
								     System.out.println("Please select a valid amount to withdraw:\n $20 (1)\n $40 (2)\n $60 (3)\n $100 (4)\n $200 (5) \n Cancel Transaction (6) \n");
								     sc.next();
							     }
						     }

				    		 // If statements to handle different amounts to withdraw
				    		 double amountToWidhdraw = 0;
				    		 if(optionentry2 == 1){
				    			 amountToWidhdraw = 20;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWidhdraw)){
				    			 withdraw = activeCustomer.Widhdraw(activeCustomer.CustomerAccount, amountToWidhdraw);
				    			 }
				    			 }else if(optionentry2 == 2){
				    			 amountToWidhdraw = 40;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWidhdraw)){
				    			 withdraw = activeCustomer.Widhdraw(activeCustomer.CustomerAccount, amountToWidhdraw);
				    			 }
				    			 }else if(optionentry2 == 3){
				    			 amountToWidhdraw = 60;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWidhdraw)){
				    			 withdraw = activeCustomer.Widhdraw(activeCustomer.CustomerAccount, amountToWidhdraw);
				    			 }
				    			 }else if(optionentry2 == 4){
				    			 amountToWidhdraw = 100;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWidhdraw)){
				    			 withdraw = activeCustomer.Widhdraw(activeCustomer.CustomerAccount, amountToWidhdraw);
				    			 }
				    			 }else if(optionentry2 == 5){
				    			 amountToWidhdraw = 200;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWidhdraw)){
					    			 withdraw = activeCustomer.Widhdraw(activeCustomer.CustomerAccount, amountToWidhdraw);
				    			 }
				    		
			    			 // If option 6 chosen, cancel transaction and return to menu
				    		 }else if(optionentry2 == 6){
				    			 System.out.println("Transaction cancelled");
				    			 withdraw = true;
				    		 }else{
				    			 // Message for invalid entry
				    			 System.out.println("Invalid input!");
				    		 }
				    		 
				    	}
			    		// If deposit selected ...
				    	 }else if(optionentry == 3){
				    		 System.out.println("Please enter the amount to deposit in cents");
				    		 double amounttodeposit = 0;
						     correctInput = true;
						     
						     // validate input
						     while(correctInput){
							     if(sc.hasNextInt()){
							    	 amounttodeposit = sc.nextInt();
							    	 correctInput = false;
							     }else{
								     System.out.println("Please enter a valid amount to deposit in cents");
								     sc.next();
							     }
						     }

				    		 double actualamount;
				    		 // if 0 entered, go back to main menu
				    		 if(amounttodeposit == 0){
				    		 }else if (amounttodeposit>0){
			    			 // If an amount is entered, perform deposit
				    		actualamount = amounttodeposit / 100;
				    		
				    		System.out.println("Please deposit envelope! (Type 1 when envelope is deposited!)");
				    		int yes = 0;
						     
				    		// validate input
				    		correctInput = true;
						     while(correctInput){
							     if(sc.hasNextInt()){
							    	 yes = sc.nextInt();
							    	 correctInput = false;
							     }else{
								     System.out.println("Invalid number (Please Type 1 when envelope is deposited!)");
								     sc.next();
							     }
						     }

				    		// if user "deposits envelope" perform deposit of money
				    		if(yes == 1){
				    			activeCustomer.Deposit(activeCustomer.CustomerAccount, actualamount);
				    			atm1.Dispenser.setBalance(atm1.Dispenser.getBalance() + actualamount);
				    			System.out.println("Money has been deposited to the account number: " + activeCustomer.CustomerAccount.getAccountNumber());
				    		}else{
				    			// cancel transaction if envelope not received
				    			System.out.println("No envelope received! ... Transaction Cancelled");
				    		}
				    		 }else{
				    			 // error message for invalid input
				    			 System.out.println("Invalid entry!");
				    		 }
				    		 
				    	// If exit option is selected return to log in screen	 
				    	 }else if(optionentry == 4){
				    		 session = false;
				    		 exit = false;
				    		 
				    		 System.out.println("Thank you for your visit!");
				    	 }
				    		 else{
				    		 System.out.println("Invalid entry!");
				    	 }

		    	}	
		    	 
		     }
		     
	     }

	}

}
