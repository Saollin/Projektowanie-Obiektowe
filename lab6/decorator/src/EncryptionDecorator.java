public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String writeData(String data) {
        return Encryption.encodeMessage(data,3);
    }

    @Override
    public String readData(String data) {
        return Encryption.decodeMessage(data,3);
    }
}
