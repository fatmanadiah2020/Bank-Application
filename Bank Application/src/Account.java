
public class Account {

	private int AccountNumber;
	private int Pin;
	private double Balance;
	
	// Constructor
	public Account(int accountNumber, int pin, double balance) {
		AccountNumber = accountNumber;
		Pin = pin;
		Balance = balance;
	}

	// Getters and Setters
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
	// method to display balance of customer's account
	public void showBalance(){
		System.out.println("The balance of the account number: " + getAccountNumber() + " is: " +getBalance());
	}
	
	
}
