package Padroes_Estruturais.Bridge;

/**
 * SmallMotor é semelhnte ao BigMotor. Tem apenas 100 cavalos.
 */

public class SmallMotor implements Motor {

    int ncavalos;

    public SmallMotor() {ncavalos = 100;}

    @Override
    public int go() {
        System.out.println("SmallMotor está a andar");
        return ncavalos;
    }
    
}
