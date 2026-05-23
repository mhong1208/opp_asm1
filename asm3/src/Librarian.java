import java.time.LocalDate;

public class Librarian {
    private final Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public String borrowBook(String readerId, String bookId, LocalDate borrowDate, int loanDays) {
        Reader reader = library.findReaderById(readerId);
        if (reader == null) {
            return "Không tìm thấy độc giả với mã: " + readerId;
        }
        Book book = library.findBookById(bookId);
        if (book == null) {
            return "Không tìm thấy sách với mã: " + bookId;
        }
        if (!book.isAvailable()) {
            return "Sách hiện không còn trong kho: " + book.getTitle();
        }
        int currentBorrowed = library.countActiveBorrowedBooks(reader);
        if (currentBorrowed >= reader.getMaxBorrowLimit()) {
            return String.format("Độc giả %s đã mượn %d cuốn, vượt giới hạn %d cuốn.",
                    reader.getName(), currentBorrowed, reader.getMaxBorrowLimit());
        }
        BorrowSlip slip = library.borrowBook(reader, book, borrowDate, loanDays);
        if (slip == null) {
            return "Không thể tạo phiếu mượn. Vui lòng kiểm tra dữ liệu.";
        }
        return String.format("Mượn thành công. Mã phiếu: %s, hạn trả: %s",
                slip.getSlipId(), slip.getDueDate());
    }

    public String returnBook(String slipId, LocalDate returnDate) {
        BorrowSlip slip = library.findSlipById(slipId);
        if (slip == null) {
            return "Không tìm thấy phiếu mượn với mã: " + slipId;
        }
        if (slip.isReturned()) {
            return "Phiếu mượn này đã được trả trước đó.";
        }
        long fine = library.returnBook(slip, returnDate);
        if (fine < 0) {
            return "Lỗi khi trả sách.";
        }
        if (fine == 0) {
            return "Trả sách thành công. Không phải đóng tiền phạt.";
        }
        return String.format("Trả sách thành công. Tổng tiền phạt: %,d VND.", fine);
    }
}
