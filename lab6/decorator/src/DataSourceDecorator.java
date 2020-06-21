public abstract class DataSourceDecorator implements DataSource {
    private DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public abstract String writeData(String data);

    public abstract String readData(String data);

}
