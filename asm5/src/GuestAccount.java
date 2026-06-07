public class GuestAccount extends DigitalAccount {
    private String name;

    public GuestAccount(String accountId, String name) {
        super(accountId, name);
        this.name = name;
    }

    @Override
    public boolean authenticate(String credential) {
        // no authentication required for guest
        return true;
    }

    @Override
    public int getDownloadLimit() {
        return 1;
    }
}
