public class FacultyReader extends CardHolder {
    public FacultyReader(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 3000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[GV] " + super.getInfo() + " | Han muon: " + getMaxBorrowLimit();
    }

    @Override
    public void renewCard(int months) {
        System.out.println(getName() + " (Faculty): Renewed for " + months + " months.");
    }
}
