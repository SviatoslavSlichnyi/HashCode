import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private Integer numsOfBooks;
    private Integer numsOfLibraries;
    private Integer daysForScanning;
    private List<Integer> scoresOfBooks;
    private List<Book> books;
    private List<Library> libraries;

    public Database() {
        books = new ArrayList<>();
        libraries = new ArrayList<>();
        scoresOfBooks = new ArrayList<>();
    }

    public Database(Integer numsOfBooks, Integer numsOfLibraries, Integer daysForScanning, List<Book> books, List<Library> libraries) {
        this.numsOfBooks = numsOfBooks;
        this.numsOfLibraries = numsOfLibraries;
        this.daysForScanning = daysForScanning;
        this.books = books;
        this.libraries = libraries;
    }

    public void read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner in = new Scanner(file);

        readFirstLine(in.nextLine());

        readScoresOfBooks(in.nextLine());

        readLibraries(in);

        in.close();
    }

    private void readFirstLine(String line) {
        Scanner scanner = new Scanner(line);

        this.numsOfBooks = scanner.nextInt();
        this.numsOfLibraries = scanner.nextInt();
        this.daysForScanning = scanner.nextInt();

        scanner.close();
    }

    private void readScoresOfBooks(String line) {
        Scanner sc = new Scanner(line);

        while (sc.hasNextInt()) {
            Integer score = sc.nextInt();
            scoresOfBooks.add(score);
        }

        sc.close();
    }

    private void readLibraries(Scanner in) {
        int libsId = 0;
        while (in.hasNextLine()) {
            ++libsId;
            String firstLine = in.nextLine();
            String secondLine = in.nextLine();
            Library lib = readLib(libsId, firstLine, secondLine);
            libraries.add(lib);
        }
    }

    private Library readLib(Integer id, String firstLine, String secondLine) {
        Library lib = new Library(id);

        readLibraryFirstLine(lib, firstLine);
        readLibrarySecondLine(lib, secondLine);

        return lib;
    }

    private void readLibraryFirstLine(Library lib, String line) {
        Scanner sc = new Scanner(line);

        Integer numOfBooks = sc.nextInt();
        Integer signupDays = sc.nextInt();
        Integer numOfBooksShippedPerDay = sc.nextInt();

        lib.setNumsOfBook(numOfBooks);
        lib.setSignupDays(signupDays);
        lib.setNumsOfBooksShippedPerDay(numOfBooksShippedPerDay);

        sc.close();
    }

    private void readLibrarySecondLine(Library lib, String line) {
        Scanner sc = new Scanner(line);


        while (sc.hasNextInt()) {
            Integer id = sc.nextInt();
            Integer score = findScore(id);

            Book book = new Book(id, score);

            books.add(book);
            lib.addBook(book);
        }

        sc.close();
    }

    private Integer findScore(Integer bookId) {
        return scoresOfBooks.get(bookId);
    }

    public Integer getNumsOfBooks() {
        return numsOfBooks;
    }

    public Integer getNumsOfLibraries() {
        return numsOfLibraries;
    }

    public Integer getDaysForScanning() {
        return daysForScanning;
    }

    public List<Integer> getScoresOfBooks() {
        return scoresOfBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void write() {



    }

}
