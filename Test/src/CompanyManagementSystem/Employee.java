package CompanyManagementSystem;

import java.util.List;

public class Employee implements SalaryCalculator {

	private Integer empId;
	private String name;
	private String email;
	private String designation;
	private int workinfHrs;
	private Double salary;
	List<Employee> empl;
	public Employee() {

	}

	public Employee(int empId, String name, String email, String designations, int workingHrs, double salary) {
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.designation = designations;
		this.workinfHrs = workingHrs;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getWorkinfHrs() {
		return workinfHrs;
	}

	public void setWorkinfHrs(int workinfHrs) {
		this.workinfHrs = workinfHrs;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		try {
			if(salary<5000) {
				throw new InvalidSalaryException("Salary less than 5000");
			}
			else {
				this.salary = salary;
			}
		}catch(InvalidSalaryException e)
		{
			System.out.println("Error is: "+e.getErrorMessage());
		}
		

	}

	@Override
	public double baseSalary() {
		return (getSalary() + (getSalary() * 0.10));
	}

	
}
