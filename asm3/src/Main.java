import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();
    private static final Librarian librarian = new Librarian(library);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n=== He thong quan ly thu vien ===");
            System.out.println("1. Hien thi tat ca sach");
            System.out.println("2. Tim sach theo ten hoac tac gia");
            System.out.println("3. Hien thi tat ca doc gia");
            System.out.println("4. Muon sach");
            System.out.println("5. Tra sach");
            System.out.println("6. Hien thi cac phieu muon qua han");
            System.out.println("7. Thong ke nhieu nhat");
            System.out.println("8. Thoat");
            System.out.print("Chon chuc nang: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    displayAllBooks();
                    break;
                case "2":
                    searchBooks();
                    break;
                case "3":
                    displayAllReaders();
                    break;
                case "4":
                    borrowBook();
                    break;
                case "5":
                    returnBook();
                    break;
                case "6":
                    listOverdueSlips();
                    break;
                case "7":
                    showStatistics();
                    break;
                case "8":
                    System.out.println("Ket thuc chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    private static void displayAllBooks() {
        System.out.println("\nDanh sach sach trong thu vien:");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }

    private static void searchBooks() {
        System.out.print("Nhap tu khoa tim kiem: ");
        String keyword = scanner.nextLine().trim();
        List<Book> results = library.searchBooks(keyword);
        if (results.isEmpty()) {
            System.out.println("Khong tim thay sach phu hop.");
            return;
        }
        System.out.println("Ket qua tim kiem:");
        for (Book book : results) {
            System.out.println(book);
        }
    }

    private static void displayAllReaders() {
        System.out.println("\nDanh sach doc gia:");
        for (Reader reader : library.getReaders()) {
            System.out.println(reader);
        }
    }

    private static void borrowBook() {
        System.out.print("Nhap ma doc gia: ");
        String readerId = scanner.nextLine().trim();
        System.out.print("Nhap ma sach: ");
        String bookId = scanner.nextLine().trim();
        System.out.print("Nhap ngay muon (YYYY-MM-DD): ");
        String borrowDateInput = scanner.nextLine().trim();
        System.out.print("Nhap so ngay muon: ");
        String loanDaysInput = scanner.nextLine().trim();

        try {
            LocalDate borrowDate = LocalDate.parse(borrowDateInput);
            int loanDays = Integer.parseInt(loanDaysInput);
            String result = librarian.borrowBook(readerId, bookId, borrowDate, loanDays);
            System.out.println(result);
        } catch (DateTimeParseException e) {
            System.out.println("Ngay khong hop le. Vui long nhap theo dinh dang YYYY-MM-DD.");
        } catch (NumberFormatException e) {
            System.out.println("So ngay muon phai la mot so nguyen.");
        }
    }

    private static void returnBook() {
        System.out.print("Nhap ma phieu muon: ");
        String slipId = scanner.nextLine().trim();
        System.out.print("Nhap ngay tra thuc te (YYYY-MM-DD): ");
        String returnDateInput = scanner.nextLine().trim();
        try {
            LocalDate returnDate = LocalDate.parse(returnDateInput);
            String result = librarian.returnBook(slipId, returnDate);
            System.out.println(result);
        } catch (DateTimeParseException e) {
            System.out.println("Ngay khong hop le. Vui long nhap theo dinh dang YYYY-MM-DD.");
        }
    }

    private static void listOverdueSlips() {
        System.out.print("Nhap ngay hien tai de kiem tra (YYYY-MM-DD): ");
        String currentDateInput = scanner.nextLine().trim();
        try {
            LocalDate currentDate = LocalDate.parse(currentDateInput);
            List<BorrowSlip> overdue = library.getOverdueSlips(currentDate);
            if (overdue.isEmpty()) {
                System.out.println("Khong co phieu muon nao qua han.");
                return;
            }
            System.out.println("Danh sach cac phieu muon da qua han:");
            for (BorrowSlip slip : overdue) {
                System.out.printf("%s | Tre %d ngay | Quy tien: %,d VND\n",
                        slip, slip.daysLate(currentDate), slip.calculateFine(currentDate));
            }
        } catch (DateTimeParseException e) {
            System.out.println("Ngay khong hop le. Vui long nhap theo dinh dang YYYY-MM-DD.");
        }
    }

    private static void showStatistics() {
        Book popular = library.getMostBorrowedBook();
        Reader active = library.getMostActiveReader();
        System.out.println("\nThong ke:");
        if (popular != null) {
            System.out.println("Sach duoc muon nhieu nhat: " + popular.getTitle() + " (Ma: " + popular.getId() + ")");
        } else {
            System.out.println("Chua co thong tin thong ke sach.");
        }
        if (active != null) {
            System.out.println("Doc gia muon nhieu nhat: " + active.getName() + " (Ma: " + active.getId() + ")");
        } else {
            System.out.println("Chua co thong tin thong ke doc gia.");
        }
    }

    private static void seedData() {
        library.addBook(new Book("B001", "Lap trinh Java", "Pham Van Trung", 2020, 4));
        library.addBook(new Book("B002", "Cau truc du lieu", "Do Xuan Loi", 2019, 3));
        library.addBook(new Book("B003", "Thiet ke Web", "Ngoc Tuan", 2021, 2));
        library.addBook(new Book("B004", "He dieu hanh", "Tran Hoang Nam", 2018, 1));

        library.addReader(new Reader("R001", "Nguyen Minh Anh", "nguyen.minhanh98@gmail.com", ReaderType.STUDENT));
        library.addReader(new Reader("R002", "Tran Hoang Nam", "hoangnam.tran90@gmail.com", ReaderType.LECTURER));
        library.addReader(new Reader("R003", "Le Thu Huong", "lethuhuong2001@gmail.com", ReaderType.STUDENT));
        library.addReader(new Reader("R004", "Pham Duc Long", "phamduclong88@gmail.com", ReaderType.STUDENT));
        library.addReader(new Reader("R005", "Vo Khanh Linh", "khanhlinh.vo95@gmail.com", ReaderType.LECTURER));
        library.addReader(new Reader("R006", "Bui Gia Han", "buigiahan99@gmail.com", ReaderType.STUDENT));
        library.addReader(new Reader("R007", "Dang Quoc Bao", "dangquocbao91@gmail.com", ReaderType.STUDENT));
        library.addReader(new Reader("R008", "Ngo Thanh Tung", "ngothanhtung87@gmail.com", ReaderType.LECTURER));
        library.addReader(new Reader("R009", "Huynh My Duyen", "huynhmyduyen2000@gmail.com", ReaderType.STUDENT));
        library.addReader(new Reader("R010", "Phan Nhat Minh", "phannhatminh93@gmail.com", ReaderType.STUDENT));
    }
}
