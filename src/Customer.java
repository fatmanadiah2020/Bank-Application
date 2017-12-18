
public class Customer {

	Account CustomerAccount;
	private String CustomerName;
	
	// Constructor accepts account object and name
	public Customer(Account customerAccount, String customerName) {
		super();
		CustomerAccount = customerAccount;
		CustomerName = customerName;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	// Method that handles customer withdrawals. Also checks if there is enough money in account to complete transaction
	public boolean Widhdraw(Account account, double widhdrawalAmount){
		
		double balanceAfterWidhdrawal;
		boolean valid = false;
		if(widhdrawalAmount<=account.getBalance()){
		balanceAfterWidhdrawal = account.getBalance() - widhdrawalAmount;
		account.setBalance(balanceAfterWidhdrawal);
		valid = true;
		}else{
		System.out.println("Not enough balance in your account, Please choose a smaller amount!");
		valid = false;
		}
		return valid;
		
	}
	
	// Method that handles customer deposit
	public void Deposit(Account account, double depositedAmount){
		double balanceAfterDeposit;
		balanceAfterDeposit = account.getBalance() + depositedAmount;
		account.setBalance(balanceAfterDeposit);
	}
}
