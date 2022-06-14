public class ex2 {

    public static void main (String[] args){

        ReaderInterface reader= new TextReader("p1.txt");
        System.out.println(reader.next());
        System.out.println("");
        System.out.println("-----------------------");
        reader= new NormalizationFilter(new CapitalizationFilter(new TextReader("p1.txt")));
        System.out.println(reader.next());
        System.out.println("");
        System.out.println("-----------------------");
        reader= new VowelFilter(new TextReader("p1.txt"));
        System.out.println(reader.next());
        System.out.println("");
        System.out.println("-----------------------");
    }
}
