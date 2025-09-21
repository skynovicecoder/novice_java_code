package practice.java.designpatterns.abstractfactory;

// Step 1: Alarm Interfaces
interface NetworkAlarm {
    void trigger();
}

interface Notification {
    void notifyAdmin();
}

// Step 2: Concrete LAN Alarms
class LanCpuAlarm implements NetworkAlarm {
    public void trigger() { System.out.println("LAN CPU Alarm Triggered"); }
}
class LanEmailNotification implements Notification {
    public void notifyAdmin() { System.out.println("LAN Admin notified via Email"); }
}

// Step 3: Concrete WAN Alarms
class WanCpuAlarm implements NetworkAlarm {
    public void trigger() { System.out.println("WAN CPU Alarm Triggered"); }
}
class WanSmsNotification implements Notification {
    public void notifyAdmin() { System.out.println("WAN Admin notified via SMS"); }
}

// Step 4: Abstract Factory
interface AlarmFactory {
    NetworkAlarm createAlarm();
    Notification createNotification();
}

// Step 5: Concrete Factories
class LanAlarmFactory implements AlarmFactory {
    public NetworkAlarm createAlarm() { return new LanCpuAlarm(); }
    public Notification createNotification() { return new LanEmailNotification(); }
}

class WanAlarmFactory implements AlarmFactory {
    public NetworkAlarm createAlarm() { return new WanCpuAlarm(); }
    public Notification createNotification() { return new WanSmsNotification(); }
}

// Step 6: Client
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AlarmFactory lanFactory = new LanAlarmFactory();
        AlarmFactory wanFactory = new WanAlarmFactory();

        NetworkAlarm lanAlarm = lanFactory.createAlarm();
        Notification lanNotify = lanFactory.createNotification();

        NetworkAlarm wanAlarm = wanFactory.createAlarm();
        Notification wanNotify = wanFactory.createNotification();

        lanAlarm.trigger();  // LAN CPU Alarm Triggered
        lanNotify.notifyAdmin(); // LAN Admin notified via Email

        wanAlarm.trigger();  // WAN CPU Alarm Triggered
        wanNotify.notifyAdmin(); // WAN Admin notified via SMS
    }
}
