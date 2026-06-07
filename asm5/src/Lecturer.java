public class Lecturer extends Reader {
    public Lecturer(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrow() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 1000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[GV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
