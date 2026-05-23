public class Book {
    public String title;
    public String author;
    public double price;
    public boolean inStock;

    public Book(String title, String author, double price, boolean inStock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    public void printInfo() {
        System.out.println("\nTen sach: " + title);
        System.out.println("Tac gia: " + author);
        System.out.println("Gia: " + price);
        System.out.println("Tinh trang: " + (inStock ? "Con hang" : "Het hang"));
    }

    public void applyDiscount(double percent) {
        double discountAmount = price * (percent / 100);
        price -= discountAmount;
        System.out.println("Da ap dung giam gia " + percent + "%. Gia moi: " + price );
    }

    public static void main(String[] args) {
        Book b1 = new Book("Lap trinh Java", "Pham Van Trung", 150000, true);
        Book b2 = new Book("Cau truc du lieu", "Do Xuan Loi", 200000, true);
        Book b3 = new Book("Thiet ke Web", "Ngoc Tuan", 120000, false);

        Book[] library = {b1, b2, b3};

        for (Book b : library) {
            b.printInfo();        
            b.applyDiscount(10);  
        }
    }
}