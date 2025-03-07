package CompanyManagementSystem;

public class InvalidSalaryException extends RuntimeException{

	String s;
	public InvalidSalaryException(String string) {
		this.s=string;
	}

	String getErrorMessage() {
		return s;
	}
}
