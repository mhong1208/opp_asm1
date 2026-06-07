import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();

    public void addBook(Book b) { books.add(b); }
    public void addReader(Reader r) { readers.add(r); }

    public void printAllReaders() {
        System.out.println("=== DANH SACH DOC GIA ===");
        for (Reader r : readers) {
            System.out.println(r.getInfo()); 
        }
    }

    public double calculateTotalLateFee(int daysLate) {
        double total = 0.0;
        for (Reader r : readers) {
            total += r.calculateLateFee(daysLate);
        }
        return total;
    }

    public Reader findReaderByName(String keyword) {
        String k = keyword.toLowerCase();
        for (Reader r : readers) {
            if (r.getName().toLowerCase().contains(k)) return r;
        }
        return null;
    }

    public void printSeniorReaders() {
        System.out.println("=== DANH SACH NGUOI CAO TUOI ===");
        for (Reader r : readers) {
            if (r instanceof SeniorReader) {
                SeniorReader s = (SeniorReader) r;
                System.out.println(s.getInfo() + " | Card: " + s.getSeniorCardNumber());
            }
        }
    }

    public List<Reader> getReaders() { return readers; }
}
