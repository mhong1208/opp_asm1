import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();
    private final List<BorrowSlip> borrowSlips = new ArrayList<>();
    private int slipCounter = 0;

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }

    public Reader findReaderById(String id) {
        for (Reader reader : readers) {
            if (reader.getId().equalsIgnoreCase(id)) {
                return reader;
            }
        }
        return null;
    }

    public BorrowSlip findSlipById(String id) {
        for (BorrowSlip slip : borrowSlips) {
            if (slip.getSlipId().equalsIgnoreCase(id)) {
                return slip;
            }
        }
        return null;
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.matches(keyword)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<BorrowSlip> getOverdueSlips(LocalDate currentDate) {
        List<BorrowSlip> overdue = new ArrayList<>();
        for (BorrowSlip slip : borrowSlips) {
            if (slip.isOverdue(currentDate)) {
                overdue.add(slip);
            }
        }
        return overdue;
    }

    public int countActiveBorrowedBooks(Reader reader) {
        int count = 0;
        for (BorrowSlip slip : borrowSlips) {
            if (!slip.isReturned() && slip.getReader().getId().equalsIgnoreCase(reader.getId())) {
                count++;
            }
        }
        return count;
    }

    public BorrowSlip borrowBook(Reader reader, Book book, LocalDate borrowDate, int loanDays) {
        if (reader == null || book == null) {
            return null;
        }
        if (!book.isAvailable()) {
            return null;
        }
        int currentBorrowed = countActiveBorrowedBooks(reader);
        if (currentBorrowed >= reader.getMaxBorrowLimit()) {
            return null;
        }
        boolean borrowed = book.borrowOne();
        if (!borrowed) {
            return null;
        }
        LocalDate dueDate = borrowDate.plusDays(loanDays);
        String slipId = String.format("P%04d", ++slipCounter);
        BorrowSlip slip = new BorrowSlip(slipId, reader, book, borrowDate, dueDate);
        borrowSlips.add(slip);
        return slip;
    }

    public long returnBook(BorrowSlip slip, LocalDate returnDate) {
        if (slip == null || slip.isReturned()) {
            return -1;
        }
        slip.returnBook(returnDate);
        slip.getBook().returnOne();
        return slip.calculateFine(returnDate);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<Reader> getReaders() {
        return new ArrayList<>(readers);
    }

    public List<BorrowSlip> getBorrowSlips() {
        return new ArrayList<>(borrowSlips);
    }

    public Book getMostBorrowedBook() {
        Book best = null;
        int maxCount = -1;
        for (Book book : books) {
            int count = 0;
            for (BorrowSlip slip : borrowSlips) {
                if (slip.getBook().getId().equalsIgnoreCase(book.getId())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                best = book;
            }
        }
        return best;
    }

    public Reader getMostActiveReader() {
        Reader best = null;
        int maxCount = -1;
        for (Reader reader : readers) {
            int count = 0;
            for (BorrowSlip slip : borrowSlips) {
                if (slip.getReader().getId().equalsIgnoreCase(reader.getId())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                best = reader;
            }
        }
        return best;
    }
}
