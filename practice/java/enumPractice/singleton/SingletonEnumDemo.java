package practice.java.enumPractice.singleton;

enum NetworkConfigManager {
    INSTANCE;

    private String networkName;
    private int totalAlarmsTriggered;

    NetworkConfigManager() {
        networkName = "DefaultNetwork";
    }

    public void triggerAlarm() {
        totalAlarmsTriggered++;
        System.out.println("Alarm triggered! Total: " + totalAlarmsTriggered);
    }

    public int getTotalAlarmsTriggered() {
        return totalAlarmsTriggered;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }
}

public class SingletonEnumDemo {
    public static void main(String[] args) {
        // Access the singleton instance
        NetworkConfigManager manager1 = NetworkConfigManager.INSTANCE;
        NetworkConfigManager manager2 = NetworkConfigManager.INSTANCE;

        manager1.triggerAlarm(); // Alarm triggered! Total: 1
        manager2.triggerAlarm(); // Alarm triggered! Total: 2

        // Confirm same instance
        System.out.println(manager1 == manager2); // true

        NetworkConfigManager.INSTANCE.setNetworkName("CorporateLAN");
        System.out.println(NetworkConfigManager.INSTANCE.getNetworkName());
    }
}