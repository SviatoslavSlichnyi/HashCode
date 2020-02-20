import java.util.*;

public class Library {
    private Integer id;
    private Integer numsOfBook;
    private Integer signupDays;
    private Integer numsOfBooksShippedPerDay;
    private Set<Book> books;
    private Integer profit;

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Library() {
        books = new LinkedHashSet<>();
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

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public boolean containBook(Book book) {
        return this.books.contains(book);
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
