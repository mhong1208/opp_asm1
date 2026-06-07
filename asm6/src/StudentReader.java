public class StudentReader extends CardHolder {
    public StudentReader(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 2000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[SV] " + super.getInfo() + " | Han muon: " + getMaxBorrowLimit();
    }

    @Override
    public void renewCard(int months) {
        System.out.println(getName() + " (Student): Renewed for " + months + " months.");
    }
}
