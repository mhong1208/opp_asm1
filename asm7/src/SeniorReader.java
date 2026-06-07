public class SeniorReader extends Reader {
    private String seniorCardNumber;

    public SeniorReader(String id, String name, String seniorCardNumber) {
        super(id, name);
        this.seniorCardNumber = seniorCardNumber;
    }

    public String getSeniorCardNumber() { return seniorCardNumber; }

    @Override
    public String getInfo() { return super.getReaderId() + " | " + getFullName() + " [NCT - MIEN PHAT]"; }

    @Override
    public double calculateLateFee(int daysLate) { return 0.0; }

    @Override
    public int getMaxBorrowLimit() { return Integer.MAX_VALUE; }

    @Override
    protected boolean checkSpecialCondition(Book book) { return true; }

    @Override
    protected String getSpecialConditionMessage() { return ""; }

    @Override
    protected void onBorrowSuccess(Book book) {
        super.onBorrowSuccess(book);
        System.out.println("  -> Da ghi nhan: Nguoi cao tuoi — khong thu phi phat");
    }
}
