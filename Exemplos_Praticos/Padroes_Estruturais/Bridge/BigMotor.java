package Padroes_Estruturais.Bridge;

/**
 * Um BigMotor implementa Motor.
 * BigMotor tem 350 cavalos e o método go() relatava se está ou 
 * não em funcionamento e retorna a potência.
 */

public class BigMotor implements Motor {

    int ncavalos;

    public BigMotor() {ncavalos = 350;}

    @Override
    public int go() {
        System.out.println("BigMotor está a andar");
        return ncavalos;
    }
    
}
