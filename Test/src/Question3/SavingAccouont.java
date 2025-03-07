package Question3;

public class SavingAccouont extends BankAccount{

	double interestRate;
	public SavingAccouont(double balanece,double interestRate) {
		super(balanece);
		this.interestRate=interestRate;
	}

	@Override
	double  applyInterest() {
		return interestRate;
	}

}
