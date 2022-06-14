import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {

	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private CompanyServices cs = new CompanyServices();

	public void admitEmployee(Person p, double salary) {
		Employee e = new Employee(p, salary);
		emps.add(e);
		cs.setAvg(avgSalary()); //atualizar salario medio com o do novo empregado
		cs.RegisterEmployee(e); //introduzir empregado
	}
	private double avgSalary(){
		double total=0;
		double c=0;
		for (Employee e : emps){
			total+=e.getSalary();
			c++;
		}
		return total/c;
	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}