public class Circle {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
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
    }
}