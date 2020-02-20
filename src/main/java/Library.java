import java.util.ArrayList;
import java.util.List;

public class Library {
    private Integer id;
    private List<Book> books = new ArrayList<>(100000);
    private Integer numsOfBook;
    private Integer timeToSignup;
    private Integer numsOfBooksShippedPerDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getNumsOfBook() {
        return numsOfBook;
    }

    public void setNumsOfBook(Integer numsOfBook) {
        this.numsOfBook = numsOfBook;
    }

    public Integer getTimeToSignup() {
        return timeToSignup;
    }

    public void setTimeToSignup(Integer timeToSignup) {
        this.timeToSignup = timeToSignup;
    }

    public Integer getNumsOfBooksShippedPerDay() {
        return numsOfBooksShippedPerDay;
    }

    public void setNumsOfBooksShippedPerDay(Integer numsOfBooksShippedPerDay) {
        this.numsOfBooksShippedPerDay = numsOfBooksShippedPerDay;
    }
}
