public class Student extends Reader {
    public Student(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrow() {
        return 3;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 2000.0 * daysLate;
    }

    @Override
    public String getInfo() {
        return "[SV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
