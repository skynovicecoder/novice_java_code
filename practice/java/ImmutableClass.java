package practice.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

final class Color {
    private final int red;
    private final int green;
    private final int blue;

    //controlled object creation — for example:
    //Caching (return the same instance if the value already exists).
    //Predefined instances (like Boolean.TRUE, Boolean.FALSE).
    // That’s where a private constructor + static factory method comes in.

    // Private constructor
    private Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // Static factory methods
    public static Color of(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    // Predefined immutable instances
    public static final Color RED   = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE  = new Color(0, 0, 255);

    public int getRed()   { return red; }
    public int getGreen() { return green; }
    public int getBlue()  { return blue; }
}

public final class ImmutableClass {
    private final String name;
    private final String address;
    private final Date joiningDate; // mutable!
    private final List<String> subjects; // mutable!

    //Should constructor be private?
    // Not mandatory. It can be public for normal usage,
    // or private with factory methods if you want controlled creation.
    public ImmutableClass(String name, String address, Date joiningDate, List<String> subjects) {
        this.name = name;
        this.address = address;
        this.joiningDate = new Date(joiningDate.getTime()); // defensive copy
        // defensive copy in constructor
        this.subjects = new ArrayList<>(subjects);

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getJoiningDate() {
        return new Date(joiningDate.getTime()); // defensive copy
    }

    public List<String> getSubjects() {
        // return unmodifiable copy to prevent changes
        return Collections.unmodifiableList(new ArrayList<>(subjects));
    }
}