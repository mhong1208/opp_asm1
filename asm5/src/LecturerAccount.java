public class LecturerAccount extends DigitalAccount {
    private String email;

    public LecturerAccount(String accountId, String displayName, String email) {
        super(accountId, displayName);
        this.email = email;
    }

    @Override
    public boolean authenticate(String credential) {
        return credential != null && !credential.isEmpty();
    }

    @Override
    public int getDownloadLimit() {
        return -1; 
    }
}
