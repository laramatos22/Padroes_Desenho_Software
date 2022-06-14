package ex3;

public class BibliotecaDemo {

    public static void main(String[] args) {

        Livro first = new Livro("Java Anti-Stress", 2018, "Omodionah");
        Livro second = new Livro("A Guerra dos Padrões", 2019, "Jorge Omel");
        Livro third = new Livro("A Procura da Luz", 2017, "Khumatkli");
        
        Biblioteca biblio = new Biblioteca();

        biblio.addLivro(first);
        biblio.addLivro(second);
        biblio.addLivro(third);

        biblio.gestaoLivros();

    }
    
}
