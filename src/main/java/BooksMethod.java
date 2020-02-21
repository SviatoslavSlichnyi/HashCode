import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooksMethod {
    private Database db;

    public BooksMethod(Database db) {
        this.db = db;
    }

    void run() {
        List<Library> libraries = db.getLibraries();
        for (int i = 0; i < libraries.size(); i++) {
            libraries.get(i).getBooks().sort(Collections.reverseOrder());

        }
//        libraries.sort(Collections.reverseOrder());

        DeleteOtherBooksWithLowestScore(libraries);


    }


    void DeleteOtherBooksWithLowestScore(List<Library> libraries) {
        for (int i = 0; i < libraries.size(); i++) {

            Library libary = libraries.get(i);
            for (int j = 0; j < libary.getBooks().size(); j++) {
                Book bigScoreBook = libary.getBooks().get(j);

                for (int m = i + 1; m < libraries.size(); m++) {
                    Library secondLib = libraries.get(m);
                    List<Book> books = secondLib.getBooks();


                    for (int k = 0; k < books.size(); k++) {
                        if (books.get(k).getId() == bigScoreBook.getId()) {

                            if (books.get(k).getScore() > bigScoreBook.getScore()) {
                                libary.getBooks().remove(bigScoreBook);
                            }
                            if (books.get(k).getScore().equals(bigScoreBook.getScore())) {
                                libary.getBooks().remove(bigScoreBook);
                            } else {
                                books.remove(books.get(k));
                            }


                        }


                    }


                }

            }



        }


    }

}
