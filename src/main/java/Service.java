import java.util.List;

public class Service {
    private Database database;
    static private Integer daysPast=0;


    public void result(){
        List<Library> libraries = database.getLibraries();
        for ( int i =0; i<libraries.size();i++){
            calculateProfit(libraries.get(i));
        }

    }

    public void calculateProfit(Library library){
        Integer sendDays=database.getDaysForScanning()-library.getSignupDays()-daysPast;
        List<Book> books = library.getBooks();
        library.setProfit(0);
        for (int i=0;i<sendDays*library.getNumsOfBooksShippedPerDay() && i<books.size();i++){
            library.setProfit(library.getProfit()+books.get(i).getScore());
        }

    }

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
