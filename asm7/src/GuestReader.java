public class GuestReader extends Reader {
    public GuestReader(String id, String name) { super(id, name); }

    @Override
    public String getInfo() { return "[GUEST] " + getReaderId() + " | " + getFullName(); }

    @Override
    public double calculateLateFee(int daysLate) { return 5000.0 * daysLate; }

    @Override
    public int getMaxBorrowLimit() { return 1; }

    @Override
    protected boolean checkSpecialCondition(Book book) { return true; }

    @Override
    protected String getSpecialConditionMessage() { return ""; }
}
