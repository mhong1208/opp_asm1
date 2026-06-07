public class FacultyReader extends Reader {
    public FacultyReader(String id, String name) { super(id, name); }

    @Override
    public String getInfo() { return "[GV] " + getReaderId() + " | " + getFullName(); }

    @Override
    public double calculateLateFee(int daysLate) { return 1000.0 * daysLate; }

    @Override
    public int getMaxBorrowLimit() { return 5; }

    @Override
    protected boolean checkSpecialCondition(Book book) { return true; }

    @Override
    protected String getSpecialConditionMessage() { return ""; }
}
