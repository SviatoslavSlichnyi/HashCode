import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private Integer id;
    private Integer numsOfBook;
    private Integer signupDays;
    private Integer numsOfBooksShippedPerDay;
    private List<Book> books = new ArrayList<>(100000);

    public Library() {
    }

    public Library(Integer id) {
        this.id = id;
    }

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

    public Integer getSignupDays() {
        return signupDays;
    }

    public void setSignupDays(Integer signupDays) {
        this.signupDays = signupDays;
    }

    public Integer getNumsOfBooksShippedPerDay() {
        return numsOfBooksShippedPerDay;
    }

    public void setNumsOfBooksShippedPerDay(Integer numsOfBooksShippedPerDay) {
        this.numsOfBooksShippedPerDay = numsOfBooksShippedPerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id) &&
                Objects.equals(numsOfBook, library.numsOfBook) &&
                Objects.equals(signupDays, library.signupDays) &&
                Objects.equals(numsOfBooksShippedPerDay, library.numsOfBooksShippedPerDay) &&
                Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numsOfBook, signupDays, numsOfBooksShippedPerDay, books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", numsOfBook=" + numsOfBook +
                ", signupDays=" + signupDays +
                ", numsOfBooksShippedPerDay=" + numsOfBooksShippedPerDay +
                ", books=" + books +
                '}';
    }
}
