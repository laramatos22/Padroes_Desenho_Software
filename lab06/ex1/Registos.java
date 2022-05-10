package ex1;

import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements
    private List<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        // Code to insert employee
        for (Empregado e : this.empregados){
            if(e.equals(emp))
                System.out.println("Erro! Empregado ja existe no sistema!");
        }
        this.empregados.add(emp);
    }

    public void remove(int codigo) {
        // Code to remove employee
        if (this.isEmpregado(codigo)){
            for (Empregado emp : empregados){
                if(emp.codigo() == codigo)
                    empregados.remove(emp);
            }
        }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for (Empregado e : this.empregados){
            if(e.codigo() == codigo)
                return true;
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        return empregados;
    }
}
