/*
* DESIGN RATIONALE
*
* 1. DigitalAccount is abstract because it captures shared behavior (requestDownload)
*    while leaving authentication and download limits to concrete account types.
* 2. GuestAccount and LibraryCard are not Readers because they represent access
*    credentials/accounts (IS-A account), not physical library patrons (separation
*    of concerns; composition can link a Reader to an account if needed).
* 3. Current design: simple, extensible hierarchy for different auth/limit policies.
*    Risk: authentication is simplified here; production would use secure mechanisms.
*/
public abstract class DigitalAccount {
    protected String accountId;
    protected String displayName;

    public DigitalAccount(String accountId, String displayName) {
        this.accountId = accountId;
        this.displayName = displayName;
    }

    public abstract boolean authenticate(String credential);
    public abstract int getDownloadLimit(); // -1 means unlimited

    public boolean requestDownload(int downloadsToday) {
        int limit = getDownloadLimit();
        if (limit == -1 || downloadsToday < limit) {
            System.out.println("Tai xuong thanh cong: " + (downloadsToday + 1) + "/" + (limit == -1 ? "∞" : limit));
            return true;
        }
        System.out.println("Da dat gioi han tai xuong hom nay!");
        return false;
    }
}
