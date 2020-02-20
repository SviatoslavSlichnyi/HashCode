import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private Integer numsOfBooks;
    private Integer numsOfLibraries;
    private Integer daysForScanning;
    private List<Book> books;
    private List<Library> libraries;

    public Database() {
        books = new ArrayList<>();
        libraries = new ArrayList<>();
    }

    public Database(Integer numsOfBooks, Integer numsOfLibraries, Integer daysForScanning, List<Book> books, List<Library> libraries) {
        this.numsOfBooks = numsOfBooks;
        this.numsOfLibraries = numsOfLibraries;
        this.daysForScanning = daysForScanning;
        this.books = books;
        this.libraries = libraries;
    }

    public void readFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner in = new Scanner(file);

        if (in.hasNextInt()) {
            readFirstLine(in.nextLine());
        }


        in.close();
    }

    private void readFirstLine(String line) {
        Scanner scanner = new Scanner(line);

        if (scanner.hasNextInt()) {
            this.numsOfBooks = scanner.nextInt();
        }

        if (scanner.hasNextInt()) {
            this.numsOfLibraries = scanner.nextInt();
        }

        if (scanner.hasNextInt()) {
            this.daysForScanning = scanner.nextInt();
        }

        scanner.close();
    }


}
