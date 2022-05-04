package AbstractFactory;

/**
 * Uma fábrica abstrata é uma fábrica que retorna fábricas.
 */

/**
 * AbstractFactory retorna MamiferoFactory ou ReptilFactory, através do tipo de retorno
 * de EspeciesFactory - MamiferoFactpry e ReptilFactory são subclasses de EspeciesFactory.
 */

/**
 * O polimorfismo do AbstractFactory é alcançado porque o seu método getEspeciesFactory()
 * retorna um EspecieFactory, independentemente da classe subjacente. Este polimorfismo
 * também podia ser alcançado através de uma interface em vez de uma classe abstrata.
 */

public class AbstractFactory {
    public EspeciesFactory getEspeciesFactory(String type) {
        if ("mamifero".equals(type))
            return new MamiferoFactory();
        else return new ReptilFactory();
        }
    
}
