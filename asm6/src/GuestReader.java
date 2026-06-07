public class GuestReader extends Reader {
    public GuestReader(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 1; 
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 5000.0 * daysLate; 
    }

    @Override
    public String getInfo() {
        return "[GUEST] " + super.getInfo() + " | Han muon: " + getMaxBorrowLimit();
    }
}
