public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("B001", "Lap trinh Java", "Nguyen Manh", 2022, 10);
        Book b2 = new Book("B002", "CTDL va GT", "Tran Hung", 2021, 5);

        Reader sv = new Student("R001", "Le Van C", "c@student.edu");
        Reader gv = new Lecturer("R002", "Pham Thi D", "d@uni.edu");

        Library lib = new Library();
        lib.addBook(b1); lib.addBook(b2);
        lib.addReader(sv); lib.addReader(gv);

        lib.showAllBooks();
        lib.showAllReaders();
        lib.showLateFees(7);

        System.out.println("\nHan muon:");
        Reader[] readers = { sv, gv };
        for (Reader r : readers) {
            System.out.println(r.getFullName() + ": " + r.getMaxBorrow() + " cuon");
        }

        System.out.println("\n=== Digital Accounts Demo ===");
        StudentAccount sa = new StudentAccount("SA1", "Le SV", "sv@x.edu", "pwd123");
        LecturerAccount la = new LecturerAccount("LA1", "Dr. GV", "gv@uni.edu");
        GuestAccount ga = new GuestAccount("G1", "Khach");
        LibraryCard card = new LibraryCard("C1", "CardUser", "RFID-123");

        System.out.println("StudentAccount downloads:");
        sa.authenticate("pwd123");
        sa.requestDownload(2);
        sa.requestDownload(3);

        System.out.println("LecturerAccount downloads:");
        la.authenticate("otp-xyz");
        la.requestDownload(100);

        System.out.println("GuestAccount downloads:");
        ga.requestDownload(0);
        ga.requestDownload(1);

        System.out.println("LibraryCard downloads:");
        card.authenticate("RFID-123");
        card.requestDownload(1);
        card.requestDownload(2);
    }
}
