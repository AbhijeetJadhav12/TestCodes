package Question3;

import java.util.*;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter initial amount in account and interest rate ");
		double balance = sc.nextDouble();
		double interest = sc.nextDouble();
		BankAccount ba = new SavingAccouont(balance, interest);
		System.out.println("Enter amount to deposit");
		double depositAmount = sc.nextDouble();
		ba.deposit(depositAmount);
		System.out.println("Enter amount to withdraw");
		double withdrawAmount = sc.nextDouble();
		ba.withdraw(withdrawAmount);
	}

}
