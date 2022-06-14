import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

public class TextReader implements ReaderInterface{
    private String filename;
    private List<String> data = new ArrayList<String>() ;

    public TextReader(String filename){
        this.filename=filename;
        readFile();
    }
    private void readFile(){ 
        try {
            data = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext(){
        return true;
    }
    @Override
    public String next(){
        return data.get(0);
    }
}
