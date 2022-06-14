public class VowelFilter extends ReaderInterfaceDecorator{

    VowelFilter(ReaderInterface reader) {
        super(reader);
    }
    
    @Override
    public String next() {
        return getVowels(reader.next());
        
    }

    private String getVowels(String texto){
        String r = "";
        for (int i=0; i<texto.length();i++){
            if(!isVowel(texto.charAt(i)))r=r+texto.charAt(i); //check if it is NOT vowel
        }
        
        return r;
    }
    private boolean isVowel(char letra){
        letra= Character.toLowerCase(letra);
        if(letra=='a' || letra == 'e' || letra=='i' || letra == 'o' || letra == 'u') return true;
        return false;
    }
}