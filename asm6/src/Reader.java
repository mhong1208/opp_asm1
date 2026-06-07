public abstract class Reader {
    private String id;
    private String name;
    private String email;

    public Reader(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public String getInfo() {
        return String.format("%s | %s | %s", id, name, email);
    }

    public abstract int getMaxBorrowLimit();
    public abstract double calculateLateFee(int daysLate);
}
