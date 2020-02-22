import java.io.IOException;

public class Main {

    public static final String FILE_NAME[] = {"a_example.txt","b_read_on.txt","c_incunabula.txt","d_tough_choices.txt",
    "e_so_many_books.txt","f_libraries_of_the_world.txt"};

    public static void main(String[] args) throws IOException {

        Database database = new Database();
        database.read(FILE_NAME[2]);

        Service service = new Service(database);
        Submission result = service.result();

        database.write(result);

    }
}
