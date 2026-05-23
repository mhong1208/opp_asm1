public class Reader {
    private String id;
    private String name;
    private String email;
    private ReaderType type;

    public Reader(String id, String name, String email, ReaderType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ReaderType getType() {
        return type;
    }

    public void setType(ReaderType type) {
        this.type = type;
    }

    public int getMaxBorrowLimit() {
        return type.getMaxBorrow();
    }

    @Override
    public String toString() {
        return String.format("[Reader] %s - %s | %s | Type: %s | Max borrow: %d",
                id, name, email, type.name(), type.getMaxBorrow());
    }
}
