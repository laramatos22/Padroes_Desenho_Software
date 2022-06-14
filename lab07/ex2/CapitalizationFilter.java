public class CapitalizationFilter extends ReaderInterfaceDecorator{

    CapitalizationFilter(ReaderInterface reader) {
        super(reader);
    }

    @Override
    public String next(){
        return capitalize(reader.next());
    }

    private String capitalize(String texto){
        String r = "";
        r=r+Character.toUpperCase(texto.charAt(0));
        for (int i=1; i<texto.length()-1;i++){
            r=r+Character.toLowerCase(texto.charAt(i));
        }
        r=r+Character.toUpperCase(texto.charAt(texto.length()-1));
        return r;
    }
}
