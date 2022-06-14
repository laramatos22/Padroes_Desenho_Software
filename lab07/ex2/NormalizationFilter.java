import java.text.Normalizer;

public class NormalizationFilter extends ReaderInterfaceDecorator{
    NormalizationFilter(ReaderInterface reader) {
        super(reader);
    }

    //code inspiration for this method from:
    //https://stackoverflow.com/questions/3322152/is-there-a-way-to-get-rid-of-accents-and-convert-a-whole-string-to-regular-lette

    @Override
    public String next(){
        String a = Normalizer.normalize(reader.next(), Normalizer.Form.NFD);
        return a.replaceAll("[^\\p{ASCII}]", "");
    }
}
