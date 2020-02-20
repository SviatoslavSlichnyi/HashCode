import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private Database database;
    static private Integer daysPast = 0;
    List<Book> markedBooks = new ArrayList<>();

    public Service() {
    }

    public Service(Database database) {
        this.database = database;
    }

    public Submission result() {
        Submission submission = new Submission();
        List<Library> libraries = database.getLibraries();
        while (daysPast < database.getDaysForScanning() && database.getLibraries().size() > 0) {
            for (int i = 0; i < libraries.size(); i++) {
                calculateProfit(libraries.get(i));
            }
            sortLibs(libraries);
            Library mostValuableLibrary = libraries.get(0);
            LibSubmission libSubmission = new LibSubmission();
            libSubmission.setIdLib(mostValuableLibrary.getId());
            List<Book> mostValBooks = mostValuableLibrary.getBooks();
            for (int i = 0; i < mostValuableLibrary.getNumsOfBookToSend() && i<mostValuableLibrary.getBooks().size(); i++) {
                libSubmission.addBook(mostValBooks.get(i));
                markedBooks.add(mostValBooks.get(i));
            }
            submission.addLibSub(libSubmission);
            daysPast += mostValuableLibrary.getSignupDays();
            libraries.remove(mostValuableLibrary);
        }
        return submission;
    }

    private void sortLibs(List<Library> libs) {
        libs.sort(Collections.reverseOrder());
    }

    private void calculateProfit(Library library) {
        Integer sendDays = database.getDaysForScanning() - library.getSignupDays() - daysPast;
        List<Book> books = library.getBooks();
        library.setProfit(0);
        library.setNumsOfBookToSend(0);
        for (int i = 0; i < sendDays * library.getNumsOfBooksShippedPerDay() && i < books.size(); i++) {
            if (markedBooks.contains(books.get(i))) {
                books.remove(i);
                i--;
                continue;
            }
            library.setProfit(library.getProfit() + books.get(i).getScore());
            library.setNumsOfBookToSend(library.getNumsOfBookToSend() + 1);
        }

    }

    public void setDatabase(Database database) {
        this.database = database;
    }

}
