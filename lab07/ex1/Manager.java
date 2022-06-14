package ex1;

public class Manager extends EmployeeDecorator {
    
    public Manager(EmployeeInterface emp) {super(emp);}

    @Override
    public void work() {
        emp.work();
        System.out.print(" as Manager ");
    }

    public void manage() {
        System.out.print("\n" + emp.name() + " managed! ");
    }
}
