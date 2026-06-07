public class SeniorReader extends CardHolder {
    private String seniorCardNumber;

    public SeniorReader(String id, String name, String email, String seniorCardNumber) {
        super(id, name, email);
        this.seniorCardNumber = seniorCardNumber;
    }

    public String getSeniorCardNumber() { return seniorCardNumber; }

    @Override
    public int getMaxBorrowLimit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0; // miễn phí toàn bộ
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " [NCT - MIEN PHAT]";
    }

    @Override
    public void renewCard(int months) {
        System.out.println(getName() + " (Senior): Renewed for " + months + " months.");
    }
}
