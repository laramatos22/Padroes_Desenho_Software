package ex1;

public class TeamMember extends EmployeeDecorator {
    
    public TeamMember(EmployeeInterface emp) {super(emp);}

    @Override
    public void work() {
        emp.work();
        System.out.print(" as TeamMember ");
    }

    public void colaborate() {
        System.out.print("\n" + emp.name() + " colaborated! ");
    }
}
