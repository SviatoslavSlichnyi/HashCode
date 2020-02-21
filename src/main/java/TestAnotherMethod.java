import java.io.FileNotFoundException;

public class TestAnotherMethod {
    public static final String FILE_NAME = "a_example.txt";

    public static void main(String[] args) throws FileNotFoundException {

        Database database = new Database();
        database.read(FILE_NAME);
        BooksMethod method = new BooksMethod(database);
        method.run();



    }
}
