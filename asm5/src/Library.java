import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();

    public void addBook(Book b) { books.add(b); }
    public void addReader(Reader r) { readers.add(r); }

    public void showAllBooks() {
        System.out.println("=== DANH SACH SACH ===");
        for (Book b : books) System.out.println(b);
    }

    public void showAllReaders() {
        System.out.println("=== DANH SACH DOC GIA ===");
        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }

    public void showLateFees(int daysLate) {
        System.out.println("=== PHI PHAT TRE HAN (" + daysLate + " ngay) ===");
        for (Reader r : readers) {
            System.out.printf("%-25s | Fee: %,.0f VND%n", r.getFullName(), r.calculateLateFee(daysLate));
        }
    }
}
