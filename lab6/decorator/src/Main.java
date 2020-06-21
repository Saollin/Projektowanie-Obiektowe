import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        String msg = "ttest message";
        String fileName = "test.txt";

        DataSource dataSource = new FileDataSource(fileName);
        dataSource.writeData(msg);
        System.out.println(dataSource.readData(""));
    }
}
