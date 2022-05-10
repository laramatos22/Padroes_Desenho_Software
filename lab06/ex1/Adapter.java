package ex1;

public class Adapter {

    private Database db;
    private Registos rg;

    public Adapter() {
        this.db = new Database();
        this.rg = new Registos();
    }

    /**
     * Um método para adicionar um empregado.
     */
    public boolean addEmployee(Employee emp) {
        return this.db.addEmployee(emp);
    }
    public void addEmpregado(Empregado emp) {
        this.rg.insere(emp);
    }

    /**
     * Um método para remover um empregado, dado o número de funcionário
     */
    public void removeEmployee(int numEmp) {
        this.db.deleteEmployee(numEmp);
        this.rg.remove(numEmp);
    }

    /**
     * Um método para verificar se um empregado existe na empresa, 
     * dado o número do empregado.
     */
    public boolean EmployeeExists(int numEmp) {
        if (this.rg.isEmpregado(numEmp))
            System.out.println("Empregado pertence à companhia");
        else {
            for (Employee emp : this.db.getAllEmployees()) {
                if (emp.getEmpNum() == numEmp){
                    System.out.println("Employee belongs to company!");
                    return true;
                }
            }
        }
        System.out.println("O empregado não existe!");
        return false;
    }

    /**
     * Um método para imprimir os registos de todos os funcionários.
     */
    public void printAllEmployees() {
        for (Employee empDB : this.db.getAllEmployees()) {
            System.out.println(empDB.getName());
        }
        for (Empregado empRG : this.rg.listaDeEmpregados()) {
            System.out.println(empRG.nome() + " " + empRG.apelido());
        }
    }
}
