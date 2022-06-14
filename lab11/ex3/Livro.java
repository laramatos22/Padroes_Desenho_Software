package ex3;

public class Livro {

    private Livro_interface estado;
    private String titulo;
    private int ISBN;
    private static int ISBNatual = 0;
    private int ano;
    private String autor;

    public Livro(String titulo, int ano, String autor) {
        estado = new Inventario();
        this.titulo = titulo;
        ISBN = ++ISBNatual;
        this.ano = ano;
        this.autor = autor;
    }

    public String getTitulo() {return this.titulo;}
    public int getISBN() {return this.ISBN;}
    public int getAno() {return this.ano;}
    public String getAutor() {return this.autor;}

    public void setEstado(Livro_interface estado) {this.estado = estado;}

    public void regista() {
        this.estado.regista(this);
    }

    public void requisita() {
        this.estado.requisita(this);
    }

    public void reserva() {
        this.estado.reserva(this);
    }

    public void cancelaReserva() {
        this.estado.cancelaReserva(this);
    }

    public void devolve() {
        this.estado.devolve(this);
    }

    public String toString() {
        return String.format("Livro %-5d %-20s %-20s %-15s", 
                                ISBN, titulo, autor, "[" + estado.getClass().getSimpleName() + "]");
    }
    
}
