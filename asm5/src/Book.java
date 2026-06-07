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

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return String.format("[Book] %s - %s | %s | %d | Qty: %d", id, title, author, year, quantity);
    }
}
