import java.util.List;

public class LibSubmission {
    private Integer idLib;
    private Integer numsOfBooksToSend;
    private List<Book> books;

    public Integer getIdLib() {
        return idLib;
    }

    public void setIdLib(Integer idLib) {
        this.idLib = idLib;
    }

    public Integer getNumsOfBooksToSend() {
        return numsOfBooksToSend;
    }

    public void setNumsOfBooksToSend(Integer numsOfBooksToSend) {
        this.numsOfBooksToSend = numsOfBooksToSend;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
