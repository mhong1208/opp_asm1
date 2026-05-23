public enum ReaderType {
    STUDENT(3),
    LECTURER(5);

    private final int maxBorrow;

    ReaderType(int maxBorrow) {
        this.maxBorrow = maxBorrow;
    }

    public int getMaxBorrow() {
        return maxBorrow;
    }

    public static ReaderType fromString(String value) {
        if (value == null) {
            return null;
        }
        switch (value.trim().toLowerCase()) {
            case "sinh vien":
            case "sinh_vien":
            case "student":
                return STUDENT;
            case "giang vien":
            case "giang_vien":
            case "lecturer":
            case "faculty":
                return LECTURER;
            default:
                return null;
        }
    }
}
