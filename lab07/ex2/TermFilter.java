public class TermFilter extends ReaderInterfaceDecorator{
    private String termo;
    TermFilter(ReaderInterface reader, String term) {
        super(reader);
        termo=term;
    }

    @Override
    public String next(){
        if(reader.next().contains(termo)) return reader.next(); //se encontra o termo devolve o texto
        return "";
    }
}
