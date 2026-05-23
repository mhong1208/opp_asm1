// Đề bài: Xây dựng class Rectangle mô phỏng hình chữ nhật, áp dụng constructor overloading. 
// Yêu cầu cụ thể: 
// 1. Khai báo 2 thuộc tính: width (double), height (double) 
// 2. Viết 3 constructor (overloading):  
// - Không tham số: tạo hình vuông cạnh 1 (width = 1, height = 1) 
// - 1 tham số side: tạo hình vuông cạnh side (width = side, height = side) 
// - 2 tham số width, height: tạo hình chữ nhật bình thường (dùng this) 
// 3. Viết các phương thức:  
// - getArea(): trả về diện tích 
// - getPerimeter(): trả về chu vi 
// - isSquare(): trả về true nếu là hình vuông, ngược lại false 
// 4. Viết main test cả 3 cách tạo object, in diện tích, chu vi, và kiểm tra có phải hình vuông 
// không. 
// Phần mở rộng (điểm cộng): 
// - Thêm constructor thứ 4 nhận vào 1 object Rectangle khác để tạo bản sao (copy 
// constructor). 
// - Thêm phương thức scale(double factor) để phóng to/thu nhỏ hình chữ nhật theo hệ 
// số. 
// - Suy nghĩ: tại sao không thể có 2 constructor cùng nhận 1 tham số double? Hãy thử và 
// giải thích lỗi. 
public class Rectangle {
    public double width;
    public double height;

    // Constructor không tham số: hình vuông cạnh 1
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Constructor 1 tham số: hình vuông cạnh side
    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }

    // Constructor 2 tham số: hình chữ nhật bình thường
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Phần mở rộng: Copy constructor
    public Rectangle(Rectangle other) {
        this.width = other.width;
        this.height = other.height;
    }

    /* 
     * Giải thích phần mở rộng: 
     * Tại sao không thể có 2 constructor cùng nhận 1 tham số double?
     * Trả lời: Trong Java, overloading được phân biệt dựa trên "signature" (chữ ký) của phương thức/constructor, 
     * tức là số lượng, kiểu dữ liệu và thứ tự các tham số. 
     * Nếu có 2 constructor cùng nhận 1 tham số kiểu double,
     * trình biên dịch sẽ không thể biết được chúng ta đang muốn gọi constructor nào khi khởi tạo bằng new Rectangle(5.0),
     * do cả 2 đều có cùng chữ ký là Rectangle(double). Điều này sẽ gây ra lỗi biên dịch. 
     */

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public boolean isSquare() {
        return width == height;
    }

    // Phần mở rộng: scale hình chữ nhật
    public void scale(double factor) {
        this.width *= factor;
        this.height *= factor;
    }
}
