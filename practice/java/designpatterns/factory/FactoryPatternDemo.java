package practice.java.designpatterns.factory;

// Step 1: Define Alarm interface
interface NetworkAlarm {
    void trigger();
}

// Step 2: Concrete Alarm implementations
class CpuThresholdAlarm implements NetworkAlarm {
    @Override
    public void trigger() {
        System.out.println("CPU Threshold Alarm Triggered!");
    }
}

class MemoryThresholdAlarm implements NetworkAlarm {
    @Override
    public void trigger() {
        System.out.println("Memory Threshold Alarm Triggered!");
    }
}

class DiskThresholdAlarm implements NetworkAlarm {
    @Override
    public void trigger() {
        System.out.println("Disk Threshold Alarm Triggered!");
    }
}

// Step 3: Factory class
class NetworkAlarmFactory {
    public static NetworkAlarm getAlarm(String type) {
        return switch (type.toLowerCase()) {
            case "cpu" -> new CpuThresholdAlarm();
            case "memory" -> new MemoryThresholdAlarm();
            case "disk" -> new DiskThresholdAlarm();
            default -> throw new IllegalArgumentException("Unknown alarm type: " + type);
        };
    }
}

// Step 4: Client
public class FactoryPatternDemo {
    public static void main(String[] args) {
        NetworkAlarm cpuAlarm = NetworkAlarmFactory.getAlarm("cpu");
        NetworkAlarm memAlarm = NetworkAlarmFactory.getAlarm("memory");

        cpuAlarm.trigger(); // CPU Threshold Alarm Triggered!
        memAlarm.trigger(); // Memory Threshold Alarm Triggered!
    }
}