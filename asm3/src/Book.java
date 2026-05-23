public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    private int quantity;

    public Book(String id, String title, String author, int year, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean borrowOne() {
        if (quantity > 0) {
            quantity -= 1;
            return true;
        }
        return false;
    }

    public void returnOne() {
        quantity += 1;
    }

    public boolean matches(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return title.toLowerCase().contains(lowerKeyword)
                || author.toLowerCase().contains(lowerKeyword);
    }

    @Override
    public String toString() {
        return String.format("[Book] %s - %s by %s (%d) | Quantity: %d",
                id, title, author, year, quantity);
    }
}
