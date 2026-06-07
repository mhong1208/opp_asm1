import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Book b1 = new Book("B001", "Lap trinh Java");
        Book b2 = new Book("B002", "CTDL & GT");
        lib.addBook(b1); lib.addBook(b2);

        StudentReader s = new StudentReader("R001", "Le Van C", "c@stu.edu");
        FacultyReader f = new FacultyReader("R002", "Pham Thi D", "d@uni.edu");
        SeniorReader sr = new SeniorReader("R003", "Nguyen A", "a@senior.org", "CC2024001");
        GuestReader g = new GuestReader("R004", "Khach LM", "guest@local");

        lib.addReader(s); lib.addReader(f); lib.addReader(sr); lib.addReader(g);

        // 1. printAllReaders
        lib.printAllReaders();

        // 2. calculateTotalLateFee
        System.out.printf("Total late fee (7 days): %, .0f VND\n", lib.calculateTotalLateFee(7));

        // 3. findReaderByName
        Reader found = lib.findReaderByName("Pham");
        System.out.println("Found: " + (found == null ? "<none>" : found.getInfo()));

        // 4. printSeniorReaders
        lib.printSeniorReaders();

        List<CardHolder> cardHolders = new ArrayList<>();
        cardHolders.add(s); cardHolders.add(f); cardHolders.add(sr);
        renewAllReaders(cardHolders, 12);

        printFeeReport(lib.getReaders(), 7);
    }

    public static void renewAllReaders(List<CardHolder> list, int months) {
        for (CardHolder c : list) c.renewCard(months);
    }

    public static void printFeeReport(List<Reader> readers, int daysLate) {
        System.out.println("=== FEE REPORT ===");
        for (Reader r : readers) {
            System.out.printf("%s -> Fee: %,.0f VND\n", r.getName(), r.calculateLateFee(daysLate));
        }
    }
}
