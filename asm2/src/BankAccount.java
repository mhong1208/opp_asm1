public class BankAccount {
    // 1. Khai bao cac thuoc tinh private
    private String accountNumber;
    private String accountName;
    private double balance;

    // 2. Viet constructor co 3 tham so
    public BankAccount(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        if (balance < 0) {
            this.balance = 0;
            System.out.println("Canh bao: So du ban dau khong hop le (< 0). Da gan so du = 0.");
        } else {
            this.balance = balance;
        }
    }

    // 3. Viet getter cho ca 3 thuoc tinh
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    // 4. Viet setter co validation cho Ten chu tai khoan
    public void setAccountName(String accountName) {
        if (accountName != null && !accountName.trim().isEmpty()) {
            this.accountName = accountName;
        } else {
            System.out.println("Loi cap nhat: Ten chu tai khoan khong hop le.");
        }
    }

    /*
     * Mo rong: Tai sao so tai khoan khong nen co setter?
     * Tra loi: So tai khoan la dinh danh duy nhat cua mot tai khoan ngan hang,
     * thuong duoc cap phat mot lan khi mo tai khoan va khong bao gio thay doi trong suot vong doi cua tai khoan.
     * Viec cho phep thay doi so tai khoan qua setter se dan den nguy co sai lech du lieu,
     * rui ro bao mat va lam hong tinh toan ven du lieu trong he thong (nhu khong truy vet duoc giao dich cu).
     */

    // 5. Cac phuong thuc nap/rut tien
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Nap thanh cong " + amount + ". So du moi: " + this.balance);
        } else {
            System.out.println("Loi nap tien: So tien nap phai lon hon 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("Rut thanh cong " + amount + ". So du moi: " + this.balance);
        } else if (amount <= 0) {
            System.out.println("Loi rut tien: So tien rut phai lon hon 0.");
        } else {
            System.out.println("Loi rut tien: So du khong du (So du hien tai: " + this.balance + ").");
        }
    }

    // 6. Phuong thuc displayInfo()
    public void displayInfo() {
        String maskedAccount = "****";
        if (accountNumber != null) {
            if (accountNumber.length() >= 4) {
                maskedAccount += accountNumber.substring(accountNumber.length() - 4);
            } else {
                maskedAccount += accountNumber;
            }
        }
        System.out.println("Tai khoan: " + maskedAccount + " | Chu the: " + accountName + " | So du: " + balance);
    }

    // Phan mo rong: Chuyen tien
    public void transfer(BankAccount other, double amount) {
        if (other == null) {
            System.out.println("Loi chuyen tien: Tai khoan nhan khong ton tai.");
            return;
        }
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            other.balance += amount;
            System.out.println("Chuyen thanh cong " + amount + " cho tai khoan " + other.getAccountName() + ". So du con lai: " + this.balance);
        } else if (amount <= 0) {
            System.out.println("Loi chuyen tien: So tien chuyen phai lon hon 0.");
        } else {
            System.out.println("Loi chuyen tien: So du khong du (So du hien tai: " + this.balance + ").");
        }
    }
}
