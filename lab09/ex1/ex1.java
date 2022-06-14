import java.util.Iterator;
import java.util.ListIterator;

public class ex1 {
    
    public static void main (String args[]){
        VectorGeneric<Integer> VG= new VectorGeneric<>();
        for(int i=0; i<50;i++){
            VG.addElem(i);
        }
        Iterator it= VG.Iterator();
        ListIterator lit= VG.ListIterator();
        ListIterator liti=VG.ListIterator(39); //so deve ter 10 elementos restantes
        ListIterator litir=VG.ListIterator(39); //so deve ter 10 elementos restantes

        System.out.println("Testes simples");
        System.out.println("Percorrer o iterator");
        while(it.hasNext()) System.out.print(it.next()+" ");
        System.out.println("");
        System.out.println("Percorrer a list iterator");
        while(lit.hasNext()) {System.out.print(lit.next()+" ");}
        System.out.println("");
        System.out.println("Percorrer a list iterator que começa no indice 39");
        while(liti.hasNext()) System.out.print(liti.next()+" ");
        System.out.println("");
        System.out.println("Percorrer a list iterator que começa no indice 39 no sentido inverso");
        while(litir.hasPrevious()) System.out.print(litir.previous()+" ");
        System.out.println("");

        Iterator it2= VG.Iterator();
        Iterator it3= VG.Iterator();
        Iterator it4= VG.Iterator();

        while(it4.hasNext()){
            System.out.println("it4 :"+it4.next());
            System.out.println("it2 :"+it2.next());
            while(it3.hasNext()) System.out.println("it3 :"+it3.next());
        }
    }
}
