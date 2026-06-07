import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Reader> readers;
    private List<Book> books;
    private List<BorrowSlip> slips;
    private LateFeePolicy feePolicy;

    public Library() {
        readers = new ArrayList<>();
        books = new ArrayList<>();
        slips = new ArrayList<>();
        feePolicy = new StandardFeePolicy();
    }

    public void addReader(Reader r) { readers.add(r); }
    public void addBook(Book b) { books.add(b); }
    public void addBorrowSlip(BorrowSlip s) { slips.add(s); }
    public void removeBorrowSlip(BorrowSlip s) { slips.remove(s); }

    public void setFeePolicy(LateFeePolicy policy) {
        this.feePolicy = policy;
        System.out.println("Cap nhat chinh sach phi phat: " + policy.getPolicyName());
    }

    public double calculateTotalFee(int daysLate) {
        double total = 0;
        for (Reader r : readers) {
            double baseFee = r.calculateLateFee(daysLate);
            double adjusted = feePolicy.applyPolicy(baseFee);
            System.out.printf("  %-20s | Base: %6.0f | Sau CS: %6.0f VND%n", r.getFullName(), baseFee, adjusted);
            total += adjusted;
        }
        System.out.printf("Tong phi phat (%s): %.0f VND%n", feePolicy.getPolicyName(), total);
        return total;
    }

    public List<Reader> getReaders() { return readers; }
}
