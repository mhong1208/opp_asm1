public class Main {
    public static void main(String[] args) {
        System.out.println("=== ASM1 Java Base ===");
        System.out.println("Chay cac bai tap: Book, Circle, Rectangle");
        System.out.println();

        runBookExample();
        System.out.println();
        runCircleExample();
        System.out.println();
        runRectangleExample();
    }

    private static void runBookExample() {
        System.out.println("[Book] Thong tin sach va giam gia");

        Book b1 = new Book("Lap trinh Java", "Pham Van Trung", 150000, true);
        Book b2 = new Book("Cau truc du lieu", "Do Xuan Loi", 200000, true);
        Book b3 = new Book("Thiet ke Web", "Ngoc Tuan", 120000, false);

        Book[] library = {b1, b2, b3};
        for (Book b : library) {
            b.printInfo();
            b.applyDiscount(10);
            System.out.println();
        }
    }

    private static void runCircleExample() {
        System.out.println("[Circle] Tinh dien tich va tong dien tich");

        Circle[] circles = {
            new Circle(1.0),
            new Circle(2.5),
            new Circle(3.0),
            new Circle(4.2),
            new Circle(5.5)
        };

        double totalArea = 0;
        for (int i = 0; i < circles.length; i++) {
            double area = circles[i].area();
            totalArea += area;
            System.out.printf("Hinh tron %d: Dien tich = %.2f\n", i + 1, area);
        }
        System.out.printf("Tong dien tich cua 5 hinh tron: %.2f\n", totalArea);
    }

    private static void runRectangleExample() {
        System.out.println("[Rectangle] Tinh dien tich, chu vi va kiem tra hinh vuong");

        Rectangle ex1 = new Rectangle(5.0, 10.0);
        Rectangle ex2 = new Rectangle(8.0, 8.0);

        System.out.println("Vi du 1: 5 x 10");
        System.out.println("Dien tich: " + ex1.area());
        System.out.println("Chu vi: " + ex1.perimeter());
        System.out.println("La hinh vuong?: " + (ex1.isSquare() ? "Co" : "Khong"));

        System.out.println();
        System.out.println("Vi du 2: 8 x 8");
        System.out.println("Dien tich: " + ex2.area());
        System.out.println("Chu vi: " + ex2.perimeter());
        System.out.println("La hinh vuong?: " + (ex2.isSquare() ? "Co" : "Khong"));
    }
}
