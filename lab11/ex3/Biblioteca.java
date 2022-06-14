package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    public void addLivro (Livro livro) {
        livros.add(livro);
    }

    public void gestaoLivros () {
        Scanner sc = new Scanner (System.in);

        boolean err = false;
        do {
            if (!err) {
                System.out.println("*** Library ***");
                for (Livro liv : livros)
                    System.out.println(liv);
                System.out.println(
                        ">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela \n");

            }
            System.out.print(">> ");
            err = false;

            String line = sc.nextLine();
            if (!line.contains(",")) {
                System.err.println("Wrong input!!!\n");
                continue;
            }

            int livro = Integer.parseInt(line.split(",")[0]) - 1;
            int op = Integer.parseInt(line.split(",")[1]);
            switch (op) {
            case 1:
                try {
                    livros.get(livro).regista();
                } catch (Exception e) {
                    err = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            case 2:
                try {
                    livros.get(livro).requisita();
                } catch (Exception e) {
                    err = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;

            case 3:
                try {
                    livros.get(livro).devolve();
                } catch (Exception e) {
                    err = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;

            case 4:
                try {
                    livros.get(livro).reserva();
                } catch (Exception e) {
                    err = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;

            case 5:
                try {
                    livros.get(livro).cancelaReserva();
                } catch (Exception e) {
                    err = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            }
        } while (true);
    }
    
}
