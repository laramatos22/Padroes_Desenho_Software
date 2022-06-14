public class ReaderInterfaceDecorator implements ReaderInterface{
    protected ReaderInterface reader;
    String a="ola";
    ReaderInterfaceDecorator(ReaderInterface reader){
        this.reader=reader;
    }
    @Override
    public boolean hasNext() {
        return true;
    }
    @Override
    public String next() {
        return "decorator interface";
    }
}
