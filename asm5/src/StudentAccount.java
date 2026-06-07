public class StudentAccount extends DigitalAccount {
    private String email;
    private String password;

    public StudentAccount(String accountId, String displayName, String email, String password) {
        super(accountId, displayName);
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean authenticate(String credential) {
        return password != null && password.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 3;
    }
}
