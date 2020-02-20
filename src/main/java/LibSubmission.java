import java.util.List;

public class LibSubmission {

    private Integer idLib;
    private List<Book> books;

    public Integer getIdLib() {
        return idLib;
    }

    public void setIdLib(Integer idLib) {
        this.idLib = idLib;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
