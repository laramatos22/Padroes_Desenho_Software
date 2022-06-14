package ex3;

public class Disponivel implements Livro_interface {

    @Override
    public void regista(Livro livro) {
        throw new UnsupportedOperationException("Operacao nao disponivel");
    }

    @Override
    public void reserva(Livro livro) {
        livro.setEstado(new Reservado());
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
        livro.setEstado(new Emprestado());
    }
    
}
