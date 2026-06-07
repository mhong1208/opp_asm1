public class StudentReader extends Reader {
    public StudentReader(String id, String name) { super(id, name); }

    @Override
    public String getInfo() { return "[SV] " + getReaderId() + " | " + getFullName(); }

    @Override
    public double calculateLateFee(int daysLate) { return 2000.0 * daysLate; }

    @Override
    public int getMaxBorrowLimit() { return 3; }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sach tham khao chi doc tai cho — sinh vien khong duoc mang ve";
    }
}
