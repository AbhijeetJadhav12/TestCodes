package CompanyManagementSystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class ComapanyApp {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
		File f = new File("D:\\practise\\EmpDetails\\emp.txt");

		Employee emp = new Employee();
		do {
			System.out.println("1 Store Data of Employee");
			System.out.println("2 Retreive Data");
			System.out.println("3 Show Employee Details");
			System.out.println("4 Search Employee with Id");
			System.out.println("enter choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:

//				UtilityClass.isAddData();
				System.out.println("Enter id, name,designation, salary");
				int id = sc.nextInt();
				sc.nextLine();
				String name = sc.nextLine();
				String email = sc.nextLine();
				String designation = sc.nextLine();
				double salary = sc.nextDouble();
				String s = "";
				s = s.concat(String.valueOf(id) + ",");
				s = s.concat(name + ",");
				s = s.concat(designation + ",");
				s = s.concat(String.valueOf(salary));

				FileWriter wr = new FileWriter(f, true);
				BufferedWriter bw = new BufferedWriter(wr);
				bw.write(s);
				bw.newLine();
				bw.close();
				wr.close();
				break;
			case 2:
				f = new File("D:\\practise\\EmpDetails\\emp.txt");

				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					String words[] = line.split(",");
					emp = new Employee();
					emp.setEmpId(Integer.parseInt(words[0]));
					emp.setName(words[1]);
					emp.setDesignation(words[2]);
					Double sal = Double.parseDouble(words[3]);
					try {
						emp.setSalary(sal);
						employees.add(emp);
					} catch (InvalidSalaryException e) {
						System.out.println("Error: " + e.getErrorMessage());
					}
				}
				break;
			case 3:
//				System.out.println("Employee Details");
//				Stream<String> lines = Files.lines(Path.of("D:\\practise\\EmpDetails\\emp.txt"));
//				System.out.println("Lines stream is " + lines);
//				lines.filter(n -> n.startsWith("1")).forEach(System.out::println);
//				lines.forEach(System.out::println);

				for (Employee e : employees) {
					System.out.println(
							e.getEmpId() + "\t" + e.getName() + "\t" + e.getDesignation() + "\t" + e.getSalary());
				}
				break;
			case 4:
				System.out.println("Enter Employee Id for Search");
				id = sc.nextInt();
				boolean found = false;
				for (Employee e : employees) {
					if (id == e.getEmpId()) {
						System.out.println(
								e.getEmpId() + "\t" + e.getName() + "\t" + e.getDesignation() + "\t" + e.getSalary());
						found = true;
					}
				}
				if (found) {
					System.out.println("Employee Found");
				} else {
					System.out.println("No Employee Found with id: " + id);
				}
				break;
			case 5:
				List<String> update = new ArrayList<>();
				System.out.println("Enter id");
				id = sc.nextInt();

				System.out.println("Enter new Salary ");
				salary = sc.nextDouble();

				File file = new File("D:\\practise\\EmpDetails\\emp.txt");
				if (!file.exists()) {
					System.out.println("File not Found");
					return;
				}
				br = new BufferedReader(new FileReader(file));

				while ((line = br.readLine()) != null) {
					String details[] = line.split(",");
					int eId = Integer.parseInt(details[0]);
					if (id == eId) {
						details[3] = String.valueOf(salary);
						System.out.println("Salary updated Succeccfully");
					}
					update.add(String.join(",", details));
				}
				br.close();
				file = new File("D:\\practise\\EmpDetails\\emp.txt");
				bw = new BufferedWriter(new FileWriter(file));
				for (String data : update) {
					bw.write(data);
					bw.newLine();
				}
				bw.close();
				break;
			case 6:

				break;
			default:
				System.out.println("wrong choice");
			}
		} while (true);
	}

}
