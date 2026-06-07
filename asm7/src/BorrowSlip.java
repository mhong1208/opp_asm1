public class BorrowSlip {
    private Reader reader;
    private Book book;
    private String borrowDate; 
    private int daysLate;

    public BorrowSlip(Reader reader, Book book, String borrowDate, int daysLate) {
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.daysLate = daysLate;
    }

    public Reader getReader() { return reader; }
    public Book getBook() { return book; }

    public int calculateDaysLate(String currentDate) { return daysLate; }
}
