import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testGenericStack();
        testPair();
        testLibraryUtils();
    }

    private static void testGenericStack() {
        GenericStack<String> history = new GenericStack<>();
        history.push("Muon sach B001");
        history.push("Tra sach B002");
        history.push("Cap nhat doc gia R001");

        System.out.println("Top history: " + history.peek());
        System.out.println("Pop 1: " + history.pop());
        System.out.println("Pop 2: " + history.pop());

        GenericStack<Integer> errors = new GenericStack<>();
        errors.push(100);
        errors.push(200);
        errors.push(404);

        System.out.println("Error codes:");
        while (!errors.isEmpty()) {
            System.out.println(errors.pop());
        }
    }

    private static void testPair() {
        Pair<String, Integer> p1 = new Pair<>("B001", 15);
        Pair<String, Integer> p2 = new Pair<>("B002", 8);

        if (Pair.comparePairs(p1, p2)) {
            System.out.println("Higher borrow: " + p1);
        } else {
            System.out.println("Higher borrow: " + p2);
        }

        Pair<String, String> readerPair = new Pair<>("Nguyen Van An", "R001");
        Pair<String, String> swapped = Pair.swap(readerPair);
        System.out.println("Swapped reader pair: " + swapped);
    }

    private static void testLibraryUtils() {
        Book[] books = {
            new Book("B003", "Java Co Ban"),
            new Book("B001", "Lap trinh OOP"),
            new Book("B002", "Cau truc du lieu")
        };
        System.out.println("Min book: " + LibraryUtils.findMin(books));

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("B004", "Thuat toan"));
        bookList.add(new Book("B005", "He thong thong tin"));
        System.out.println("Book list:");
        LibraryUtils.printAll(bookList);

        List<Reader> readerList = new ArrayList<>();
        readerList.add(new Reader("R001", "Nguyen Van An"));
        readerList.add(new Reader("R002", "Tran Thi Binh"));
        System.out.println("Reader list:");
        LibraryUtils.printAll(readerList);

        List<Object> copyDest = new ArrayList<>();
        LibraryUtils.copyList(copyDest, bookList);
        LibraryUtils.copyList(copyDest, readerList);
        System.out.println("Copy destination:");
        LibraryUtils.printAll(copyDest);
    }
}
