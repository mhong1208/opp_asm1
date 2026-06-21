public class Reader implements Comparable<Reader> {
    private String id;
    private String name;

    public Reader(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Reader other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Reader[id=%s,name=%s]", id, name);
    }
}
