public class Book implements Comparable<Book> {
    private String id;
    private String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return String.format("Book[id=%s,title=%s]", id, title);
    }
}
