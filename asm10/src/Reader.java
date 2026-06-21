import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Reader implements Notifiable {
    private String id;
    private String name;
    private String email;
    private final List<String> notifications = new ArrayList<>();

    public Reader(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public String getInfo() {
        return String.format("%s | %s | %s", id, name, email);
    }

    public abstract int getMaxBorrowLimit();
    public abstract double calculateLateFee(int daysLate);

    @Override
    public void sendNotification(String message) {
        notifications.add(message);
        System.out.println("[" + name + "] " + message);
    }

    @Override
    public List<String> getNotificationHistory() {
        return Collections.unmodifiableList(notifications);
    }
}
