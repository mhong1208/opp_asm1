public class LibraryCard extends DigitalAccount {
    private String rfid;

    public LibraryCard(String accountId, String displayName, String rfid) {
        super(accountId, displayName);
        this.rfid = rfid;
    }

    @Override
    public boolean authenticate(String credential) {
        return rfid != null && rfid.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 2;
    }
}
