import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataSource {
    String writeData(String data) throws IOException;
    String readData(String data) throws IOException;
}
