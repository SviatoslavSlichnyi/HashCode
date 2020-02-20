public class Service {
    private Database database;
    static private Integer daysToDeadline;


    public void result(){}

    public Service(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Service() {
    }
}
