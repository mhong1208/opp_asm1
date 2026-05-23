public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("B001", "Lap trinh Java", "Pham Van Trung", 2020, 5);
        Book book2 = new Book("B002", "Cau truc du lieu", "Do Xuan Loi", 2019, 3);
        library.addBook(book1);
        library.addBook(book2);

        Reader student = new Student("R001", "Nguyen Minh Anh", "nguyen.minhanh98@gmail.com");
        Reader lecturer = new Lecturer("R002", "Tran Hoang Nam", "hoangnam.tran90@gmail.com");
        library.addReader(student);
        library.addReader(lecturer);

        System.out.println("=== Kiem thu ke thua Reader -> Student/Lecturer ===");
        library.printBooks();
        System.out.println();
        library.printReaders();
    }
}
