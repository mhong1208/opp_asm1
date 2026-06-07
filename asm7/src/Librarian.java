public class Librarian {
    private String employeeId;
    private String fullName;
    private String phone;
    private String shift;
    private Library library;

    public Librarian(String employeeId, String fullName, String phone, String shift, Library library) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.phone = phone;
        this.shift = shift;
        this.library = library;
    }

    public void processLoan(Reader reader, Book book) {
        System.out.println("[Thu thu " + fullName + "] Xu ly cho muon:");
        BorrowResult result = reader.processBorrow(book);
        System.out.println("  Ket qua: " + result.getMessage());
        if (result.isSuccess()) {
            BorrowSlip slip = new BorrowSlip(reader, book, "2024-12-01", 0);
            library.addBorrowSlip(slip);
        }
    }

    public void processReturn(BorrowSlip slip) {
        int daysLate = slip.calculateDaysLate("2024-12-01");
        if (daysLate > 0) {
            double fee = slip.getReader().calculateLateFee(daysLate);
            System.out.printf("Phat qua han %d ngay: %.0f VND%n", daysLate, fee);
        }
        slip.getBook().increaseStock();
        library.removeBorrowSlip(slip);
    }
}
