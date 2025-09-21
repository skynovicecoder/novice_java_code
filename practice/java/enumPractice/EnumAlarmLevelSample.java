package practice.java.enumPractice;

public enum EnumAlarmLevelSample {
    LOW(1, "Low priority alarm"),
    MEDIUM(2, "Medium priority alarm"),
    HIGH(3, "High priority alarm");

    // Fields
    private final int severity;
    private final String description;

    // Constructor
    EnumAlarmLevelSample(int severity, String description) {
        this.severity = severity;
        this.description = description;
    }

    // Getter methods
    public int getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    // Behavior method
    public boolean shouldNotifyAdmin() {
        // Notify admin only for MEDIUM and HIGH
        return this.severity >= 2;
    }

    // Custom behavior per constant (optional)
    public void triggerAction() {
        switch (this) {
            case LOW -> System.out.println("Log the event only: " + description);
            case MEDIUM -> System.out.println("Send email alert: " + description);
            case HIGH -> System.out.println("Send SMS & email alert: " + description);
        }
    }
}

class EnumDemo {
    public static void main(String[] args) {
        EnumAlarmLevelSample level = EnumAlarmLevelSample.HIGH;

        System.out.println("Severity: " + level.getSeverity());
        System.out.println("Description: " + level.getDescription());
        System.out.println("Notify Admin? " + level.shouldNotifyAdmin());

        // Trigger behavior
        level.triggerAction();
    }
}
