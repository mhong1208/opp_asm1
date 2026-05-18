public class Employee {
    // 1. Khai bao thuoc tinh
    private int id;
    private String name;
    private double salary;
    
    // Cac thuoc tinh static (dung chung cho toan bo class)
    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName = "TechCorp";
    private static double totalSalary = 0;

    // 2. Viet constructor
    public Employee(String name, double salary) {
        // Tu dong gan id bang nextId, sau do tang nextId len 1
        this.id = nextId++;
        
        // Tang so luong nhan vien
        employeeCount++;
        
        // Cong don vao tong luong cua toan cong ty
        totalSalary += salary;
        
        this.name = name;
        this.salary = salary;
    }

    // 3. Getter va Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        // Khi thay doi luong cua mot ca nhan, can cap nhat lai tong luong cua toan cong ty
        totalSalary = totalSalary - this.salary + salary;
        this.salary = salary;
    }

    // 4. Cac phuong thuc static
    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static double getTotalSalary() {
        return totalSalary;
    }

    /*
     * Mo rong: Neu trong main ta khong tao object nao, goi Employee.getAverageSalary() co chay duoc khong? Tai sao?
     * Tra loi:
     * - Co chay duoc. Boi vi getAverageSalary() la mot phuong thuc static, no phu thuoc vao Class (Employee)
     *   chu khong phu thuoc vao tung doi tuong cu the. Do do, ta co the goi Employee.getAverageSalary()
     *   ma khong can dung tu khoa 'new' de tao object nao.
     */
    public static double getAverageSalary() {
        if (employeeCount == 0) {
            return 0; 
        }
        return totalSalary / employeeCount;
    }

    // Phan mo rong: Doi ten cong ty
    public static void changeCompanyName(String newName) {
        companyName = newName;
    }

    // Phan mo rong: Tang luong theo phan tram
    public void raiseSalary(double percent) {
        if (percent > 0) {
            double increase = this.salary * (percent / 100.0);
            // Dung luon setSalary cap nhat totalSalary
            setSalary(this.salary + increase);
        }
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Ten: " + name + " | Luong: " + salary + " | Cong ty: " + companyName);
    }
}
