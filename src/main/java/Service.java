import java.util.Collections;
import java.util.List;

public class Service {
    private Database database;
    static private Integer daysPast=0;
    List<Book> markedBooks;

    public Submission result(){
        Submission submission = new Submission();
        List<Library> libraries = database.getLibraries();
        while (daysPast<database.getDaysForScanning() && database.getLibraries().size()>0) {
            for (int i = 0; i < libraries.size(); i++) {
                calculateProfit(libraries.get(i));
            }
            sortLibs(libraries);
            Library mostValuableLibrary = libraries.get(0);
            LibSubmission libSubmission = new LibSubmission();
            libSubmission.setIdLib(mostValuableLibrary.getId());
            libSubmission.setNumsOfBooksToSend(mostValuableLibrary.getNumsOfBookToSend());
            List<Book> mostValBooks = mostValuableLibrary.getBooks();
            for (int i = 0; i < mostValuableLibrary.getNumsOfBookToSend(); i++) {
                libSubmission.addBook(mostValBooks.get(i));
            }
            submission.setNumsOfLibs(submission.getNumsOfLibs()+1);
            submission.addLibrary(libSubmission);
            daysPast += mostValuableLibrary.getSignupDays();
            libraries.remove(mostValuableLibrary);
        }
        return submission;
    }

    private void sortLibs(List<Library> libs) {
        libs.sort(Collections.reverseOrder());
    }
    public void calculateProfit(Library library){
        Integer sendDays=database.getDaysForScanning()-library.getSignupDays()-daysPast;
        List<Book> books = library.getBooks();
        library.setProfit(0);
        library.setNumsOfBookToSend(0);
        for (int i=0;i<sendDays*library.getNumsOfBooksShippedPerDay() && i<books.size();i++){
            library.setProfit(library.getProfit()+books.get(i).getScore());
            library.setNumsOfBookToSend(library.getNumsOfBookToSend()+1);
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
