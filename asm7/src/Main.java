public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addReader(new StudentReader("SV01", "Nguyen Van A"));
        library.addReader(new FacultyReader("GV01", "Tran Thi B"));
        library.addReader(new SeniorReader("CC01", "Le Van C", "CC2024"));

        System.out.println("=== Thang binh thuong ===");
        library.calculateTotalFee(7);

        library.setFeePolicy(new CharityFeePolicy());
        System.out.println("\n=== Thang tu thien ===");
        library.calculateTotalFee(7);

        library.setFeePolicy(new WaivedFeePolicy());
        System.out.println("\n=== Thang khai truong ===");
        library.calculateTotalFee(7);

        Librarian libr = new Librarian("TT01", "Le Thi D", "0904", "Sang", library);
        Reader sv = new StudentReader("SV02", "Nguyen Van X");
        Reader nctu = new SeniorReader("CC02", "Le Van Y", "CC2025");
        Book book = new Book("B01", "Clean Code", "Robert Martin", 3, false);

        library.addReader(sv);
        library.addReader(nctu);
        library.addBook(book);

        libr.processLoan(sv, book); 
        libr.processLoan(nctu, book); 
    }
}
