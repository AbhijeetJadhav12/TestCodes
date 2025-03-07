package Question3;

public abstract class BankAccount {
	String accountNumber;
	double balance;

	public BankAccount(double balanece) {

		this.balance = balanece;
	}

	void setBalance(double balance) {
		this.balance = balance;
	}

	void deposit(double amount) {

		if (amount <= 0) {
			System.out.println("Invalid deposit");
		} else {
			setBalance(applyInterest() * balance + (balance + amount));
			;
		}
		System.out.println("Balance after deposit: "+getBalance());
	}

	void withdraw(double amount) {

		if (amount > balance) {
			System.out.println("Insufficient Funds");
		} else if (amount <= 0) {
			System.out.println("Invalid withdrawal");
		} else {
			setBalance(balance - amount);
		}
		System.out.println("Balance after withdraw: "+getBalance());
	}

	double getBalance() {
		return balance;
	}

	abstract double applyInterest();

}
