public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(FileDataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String writeData(String data) {
        return Compression.compress(data);
    }

    @Override
    public String readData(String data) {
        return Compression.decompress(data);
    }
}
