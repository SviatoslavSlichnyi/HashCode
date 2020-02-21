import java.util.*;

public class Service {
    private Database database;
    static private Integer daysPast = 0;
    Map<Integer,Book> markedBooks = new HashMap<>();

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
                markedBooks.put(mostValBooks.get(i).getId(),mostValBooks.get(i)) ;
            }
            if(libSubmission.getBooks().size()>0)
            submission.addLibSub(libSubmission);
            daysPast += mostValuableLibrary.getSignupDays();
            System.out.println(submission.getLibSubmissions().size());
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
            if (markedBooks.containsKey(books.get(i).getId())) {
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
