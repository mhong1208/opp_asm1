import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String slipId;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowSlip(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.slipId = slipId;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    public String getSlipId() {
        return slipId;
    }

    public void setSlipId(String slipId) {
        this.slipId = slipId;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public boolean isOverdue(LocalDate currentDate) {
        return !isReturned() && currentDate.isAfter(dueDate);
    }

    public long daysLate(LocalDate currentDate) {
        if (!isOverdue(currentDate)) {
            return 0;
        }
        return ChronoUnit.DAYS.between(dueDate, currentDate);
    }

    public long calculateFine(LocalDate currentDate) {
        return daysLate(currentDate) * 5000L;
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        String status = isReturned() ? "Returned" : "Borrowed";
        return String.format("[Slip] %s | Reader: %s | Book: %s | Borrow: %s | Due: %s | Status: %s",
                slipId, reader.getId(), book.getId(), borrowDate, dueDate, status);
    }
}
