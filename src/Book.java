// Bai 1
// De bai: Xay dung class Book mo phong mot cuon sach trong thu vien.
// Yeu cau cu the:
// 1. Khai bao cac thuoc tinh (chua can private): title (String), author (String), year (int),
// price (double)
// 2. Viet 2 constructor:
// - Constructor mac dinh: gan title = "Unknown", author = "Unknown", year =
// 2000, price = 0
// - Constructor co 4 tham so: nhan day du thong tin, su dung this de gan gia tri
// 3. Viet phuong thuc displayInfo() in ra toan bo thong tin sach theo dinh dang:
// 4. Sach: [title] - Tac gia: [author] - Nam: [year] - Gia: [price]
// 5. Viet class Main de test: tao 2 object, mot bang constructor mac dinh, mot bang
// constructor co tham so. Goi displayInfo() cho ca 2.
// Phan mo rong (diem cong):
// - Them constructor thu 3 chi nhan title va author, nam mac dinh la nam hien tai (2026),
// gia mac dinh la 100000.
// - Them phuong thuc applyDiscount(double percent) de giam gia sach theo phan tram
// (vd: applyDiscount(10) giam 10%).
public class Book {
    public String title;
    public String author;
    public int year;
    public double price;

    // Constructor mac dinh
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.year = 2000;
        this.price = 0.0;
    }

    // Constructor co 4 tham so
    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    // Constructor thu 3 (mo rong)
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026;
        this.price = 100000.0;
    }

    public void displayInfo() {
        System.out.println("Sach: " + title + " - Tac gia: " + author + " - Nam: " + year + " - Gia: " + price);
    }

    public void applyDiscount(double percent) {
        double discountAmount = price * (percent / 100.0);
        price -= discountAmount;
    }
}
