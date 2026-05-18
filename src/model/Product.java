package model;

import util.ProductValidator;

public class Product {
    private String productCode;
    private String name;
    private double price;
    private int quantity;
    
    // Mo rong: Category
    private Category category; 
    
    // Mo rong: Trang thai ngung kinh doanh
    private boolean isDiscontinued = false; 

    private static int counter = 1;
    private static int totalProducts = 0;
    private static double totalRevenue = 0;

    private void init(String name, double price, int quantity) {
        this.productCode = String.format("P-%04d", counter++);
        
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
        
        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            this.price = 0;
        }

        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }

        totalProducts++;
    }

    public Product() {
        init("Unknown", 0, 0);
    }

    public Product(String name, double price) {
        init(name, price, 0);
    }

    public Product(String name, double price, int quantity) {
        init(name, price, quantity);
    }
    
    public void setName(String name) {
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Loi: Ten san pham khong hop le.");
        }
    }

    public void setPrice(double price) {
        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            System.out.println("Loi: Gia khong hop le.");
        }
    }

    public void setQuantity(int quantity) {
        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            System.out.println("Loi: So luong khong hop le.");
        }
    }

    public String getProductCode() { return productCode; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public void sell(int amount) {
        if (isDiscontinued) {
            System.out.println("Loi: San pham " + name + " da ngung kinh doanh.");
            return;
        }
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            totalRevenue += amount * price;
            System.out.println("Ban thanh cong " + amount + " " + name);
        } else {
            System.out.println("Loi: So luong ban khong hop le hoac khong du ton kho (" + name + ").");
        }
    }

    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Nhap thanh cong " + amount + " " + name);
        } else {
            System.out.println("Loi: So luong nhap phai > 0.");
        }
    }

    public void displayInfo() {
        String catName = (category != null) ? category.getName() : "Chua phan loai";
        System.out.println(productCode + " - " + name + " (" + catName + ") | Gia: " + price + " | Ton kho: " + quantity + (isDiscontinued ? " [Da huy]" : ""));
    }

    public static int getTotalProducts() { return totalProducts; }
    public static double getTotalRevenue() { return totalRevenue; }

    public static String getStoreReport() {
        return String.format("--- Bao cao Cua Hang ---\nTong so san pham: %d\nTong doanh thu: %.2f", totalProducts, totalRevenue);
    }

    // Mo rong: Khuyen mai ca nhan
    public void applyPromotion(double discountPercent) {
        if (discountPercent > 0 && discountPercent <= 100) {
            this.price -= this.price * (discountPercent / 100.0);
        }
    }

    // Mo rong: Khuyen mai toan bo mang
    public static void applyGlobalPromotion(Product[] products, double discountPercent) {
        if (products != null) {
            for (Product p : products) {
                if (p != null) p.applyPromotion(discountPercent);
            }
            System.out.println("Da ap dung giam gia " + discountPercent + "% cho danh sach san pham.");
        }
    }

    /*
     * Mo rong: Neu mot san pham bi "huy" (khong ban nua), totalProducts co nen giam khong?
     * Tra loi: KHONG nen giam totalProducts.
     * Ly do: Bien totalProducts thuong duoc dung de quan ly tong so "ban ghi" loai san pham
     * da tung duoc tao ra trong he thong va co anh huong den viec phan tich so lieu lich su.
     * Neu xoa han se lam mat du lieu da ban truoc do. Thay vao do, ta su dung co boolean 'isDiscontinued'
     * de danh dau san pham da ngung kinh doanh. No van nam trong he thong de tham chieu,
     * nhung khong the ban duoc nua.
     */
    public void discontinue() {
        this.isDiscontinued = true;
        System.out.println("San pham " + name + " da duoc danh dau ngung kinh doanh.");
    }
}
