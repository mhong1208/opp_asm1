import model.Product;
import model.Category;

public class Main {
    public static void main(String[] args) {
        // --- Test Book Class ---
        System.out.println("========== TEST BOOK ==========");
        // Tao 1 object bang constructor mac dinh
        Book b1 = new Book();
        // Tao 1 object bang constructor co tham so
        Book b2 = new Book("Lap trinh Java", "Pham Van Trung", 2023, 150000);
        // (Mo rong) Tao 1 object bang constructor 2 tham so
        Book b3 = new Book("Cau truc du lieu", "Do Xuan Loi");

        b1.displayInfo();
        b2.displayInfo();
        b3.displayInfo();

        System.out.println("\nSau khi giam gia 10%:");
        b2.applyDiscount(10);
        b3.applyDiscount(10);
        
        b2.displayInfo();
        b3.displayInfo();

        // --- Test Rectangle Class ---
        System.out.println("\n========== TEST RECTANGLE ==========");
        // Test 3 cach tao object
        Rectangle ex1 = new Rectangle(); // Mac dinh: 1x1
        Rectangle ex2 = new Rectangle(8.0); // 1 tham so: 8x8
        Rectangle ex3 = new Rectangle(5.0, 10.0); // 2 tham so: 5x10

        System.out.println("Vi du 1 (Khong tham so):");
        System.out.println("Dien tich: " + ex1.getArea());
        System.out.println("Chu vi: " + ex1.getPerimeter());
        System.out.println("La hinh vuong?: " + (ex1.isSquare() ? "Co" : "Khong"));

        System.out.println("\nVi du 2 (1 tham so - 8):");
        System.out.println("Dien tich: " + ex2.getArea());
        System.out.println("Chu vi: " + ex2.getPerimeter());
        System.out.println("La hinh vuong?: " + (ex2.isSquare() ? "Co" : "Khong"));

        System.out.println("\nVi du 3 (2 tham so - 5x10):");
        System.out.println("Dien tich: " + ex3.getArea());
        System.out.println("Chu vi: " + ex3.getPerimeter());
        System.out.println("La hinh vuong?: " + (ex3.isSquare() ? "Co" : "Khong"));

        // Phan mo rong: Copy constructor va scale
        System.out.println("\n--- Mo rong ---");
        Rectangle ex4 = new Rectangle(ex3); // Copy ex3 (5x10)
        ex4.scale(2.0); // Phong to gap 2 -> (10x20)
        System.out.println("Sau khi copy ex3 va scale(2.0):");
        System.out.println("Dien tich moi: " + ex4.getArea());
        System.out.println("Chu vi moi: " + ex4.getPerimeter());

        // --- Test Circle Class ---
        System.out.println("\n========== TEST CIRCLE ==========");
        Circle[] circles = new Circle[5];
        
        circles[0] = new Circle(1.0);
        circles[1] = new Circle(2.5);
        circles[2] = new Circle(3.0);
        circles[3] = new Circle(4.2);
        circles[4] = new Circle(5.5);

        double totalArea = 0;

        System.out.println("Danh sach hinh tron: ");
        for (int i = 0; i < circles.length; i++) {
            double a = circles[i].area();
            totalArea += a;
            
            System.out.printf("Hinh tron %d: Dien tich = %.2f\n", 
                              (i + 1), a);
        }

        System.out.println("Tong dien tich cua 5 hinh tron la: " + totalArea);

        // --- Test BankAccount Class ---
        System.out.println("\n========== TEST BANK ACCOUNT ==========");
        
        // 7. Tao tai khoan, thu truong hop loi so am
        BankAccount acc1 = new BankAccount("123456789", "Nguyen Van A", -50000);
        acc1.displayInfo();

        System.out.println("\nThu nap/rut tien:");
        // Nap tien hop le
        acc1.deposit(100000);
        // Nap tien so am (loi)
        acc1.deposit(-20000);
        
        // Rut tien hop le
        acc1.withdraw(30000);
        // Rut qua so du (loi)
        acc1.withdraw(200000);
        
        acc1.displayInfo();

        // Mo rong: Chuyen tien
        System.out.println("\n--- Mo rong: Chuyen tien ---");
        BankAccount acc2 = new BankAccount("987654321", "Tran Thi B", 50000);
        acc2.displayInfo();
        
        // Chuyen 20000 tu acc1 sang acc2
        acc1.transfer(acc2, 20000);
        
        // In lai thong tin sau khi chuyen
        System.out.println("Sau khi chuyen:");
        acc1.displayInfo();
        acc2.displayInfo();

        // --- Test Employee Class ---
        System.out.println("\n========== TEST EMPLOYEE ==========");
        
        // 5. Tao 3 nhan vien
        Employee emp1 = new Employee("Alice", 15000000);
        Employee emp2 = new Employee("Bob", 20000000);
        Employee emp3 = new Employee("Charlie", 18000000);

        // In id cua tung nguoi (ky vong 1000, 1001, 1002)
        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();

        // In thong ke chung (static)
        System.out.println("\n--- Thong ke chung ---");
        System.out.println("Tong so nhan vien: " + Employee.getEmployeeCount());
        System.out.println("Tong luong toan cong ty: " + Employee.getTotalSalary());
        System.out.println("Luong trung binh: " + Employee.getAverageSalary());

        // Thay doi luong mot nhan vien (tang luong)
        System.out.println("\n--- Sau khi doi luong Bob ---");
        emp2.setSalary(25000000); // Doi truc tiep
        emp3.raiseSalary(10);     // Tang luong 10%

        emp2.displayInfo();
        emp3.displayInfo();

        System.out.println("Tong luong toan cong ty (da cap nhat): " + Employee.getTotalSalary());
        System.out.println("Luong trung binh (da cap nhat): " + Employee.getAverageSalary());

        // Test phan doi ten cong ty (mo rong)
        System.out.println("\n--- Doi ten cong ty ---");
        Employee.changeCompanyName("GlobalTech");
        emp1.displayInfo(); // Luc nay companyName cua tat ca deu thanh GlobalTech

        // --- Test Product Class ---
        System.out.println("\n========== TEST PRODUCT ==========");
        
        Category catElectronics = new Category("Dien tu");
        Category catFood = new Category("Thuc pham");

        // 4 cach tao object
        Product p1 = new Product(); 
        Product p2 = new Product("Laptop Dell", 15000000); 
        Product p3 = new Product("Iphone 15", 25000000, 50); 
        Product p4 = new Product("Banh Mi", 15000, 100); 

        // Gan category
        p2.setCategory(catElectronics);
        p3.setCategory(catElectronics);
        p4.setCategory(catFood);

        // In danh sach ban dau
        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();

        System.out.println("\n--- Thuc hien giao dich ---");
        p2.restock(20); // Nhap them 20 laptop
        p2.sell(5);     // Ban 5 laptop
        p4.sell(200);   // Loi: Ban lo so luong ton kho
        p3.sell(10);    // Ban 10 iphone

        System.out.println("\n--- Test huy san pham (discontinue) ---");
        p4.discontinue();
        p4.sell(5); // Se bao loi vi da ngung kinh doanh

        System.out.println("\n--- Test khuyen mai ---");
        Product[] electronics = {p2, p3};
        Product.applyGlobalPromotion(electronics, 10); // Giam 10%
        p2.displayInfo();
        p3.displayInfo();

        System.out.println("\n--- Bao cao cuoi cung ---");
        System.out.println(Product.getStoreReport());
    }
}

