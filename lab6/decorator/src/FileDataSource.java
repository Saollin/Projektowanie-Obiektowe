import java.io.*;

public class FileDataSource implements DataSource {
    private String fileName;

    public FileDataSource(String fileName){
        this.fileName = fileName;
    }

    public String writeData(String data) throws IOException {
        DataSourceDecorator encryption = new EncryptionDecorator(this);
        DataSourceDecorator compression = new CompressionDecorator(this);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(compression.writeData(encryption.writeData(data)));
        writer.close();
        return "";
    }

    public String readData(String data) throws IOException {

        DataSourceDecorator encryption = new EncryptionDecorator(this);
        DataSourceDecorator compression = new CompressionDecorator(this);
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String currLine = reader.readLine();

        while (currLine != null){
            stringBuffer.append(encryption.readData(compression.readData(currLine)));
            currLine = reader.readLine();
        }
        reader.close();
        return stringBuffer.toString();
    }

}
