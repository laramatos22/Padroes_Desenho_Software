package ex3;

public class Inventario implements Livro_interface {

    @Override
    public void regista(Livro livro) {
        livro.setEstado(new Disponivel());
    }

    @Override
    public void reserva(Livro livro) {
        throw new UnsupportedOperationException("Operacao nao disponivel");
    }

    @Override
    public void cancelaReserva(Livro livro) {
        throw new UnsupportedOperationException("Operacao nao disponivel");
    }

    @Override
    public void devolve(Livro livro) {
        throw new UnsupportedOperationException("Operacao nao disponivel");
    }

    @Override
    public void requisita(Livro livro) {
        throw new UnsupportedOperationException("Operacao nao disponivel");
    }
    
}
