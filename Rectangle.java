public class Rectangle {
    public double width;
    public double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return (width + height) * 2;
    }

    public boolean isSquare() {
        return width == height;
    }

    public static void main(String[] args) {
        Rectangle ex1 = new Rectangle(5.0, 10.0); 
        Rectangle ex2 = new Rectangle(8.0, 8.0); 

        System.out.println("Vi du 1: 5x10");
        System.out.println("Dien tich: " + ex1.area());
        System.out.println("Chu vi: " + ex1.perimeter());
        System.out.println("La hinh vuong?: " + (ex1.isSquare() ? "Co" : "Khong"));

        System.out.println("\nVi du 2: 8x8");
        System.out.println("Dien tich: " + ex2.area());
        System.out.println("Chu vi: " + ex2.perimeter());
        System.out.println("La hinh vuong?: " + (ex2.isSquare() ? "Co" : "Khong"));
    }
}