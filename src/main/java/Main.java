import java.io.IOException;

public class Main {

    public static final String FILE_NAME = "a_example.txt";

    public static void main(String[] args) throws IOException {

        Database database = new Database();
        database.read(FILE_NAME);

        Service service = new Service(database);
        Submission result = service.result();

        database.write(result);

    }
}
