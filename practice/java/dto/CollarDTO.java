package practice.java.dto;

import java.util.Objects;

// NOTE: Overrides equals , hashCode and toString
public class CollarDTO {
    private String color;
    private int numberPlate;

    public CollarDTO(String color, int numberPlate) {
        this.color = color;
        this.numberPlate = numberPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(int numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Number Plate:" + this.numberPlate + " with color: " + this.color;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CollarDTO collarDtoObj)) return false;
        //Collar collarObj = (Collar) other;
        return color.equals(collarDtoObj.color) && numberPlate == collarDtoObj.numberPlate;
    }

    // NOTE: equals and hashcode contract, if equals is overridden then hashcode also must be overridden

    @Override
    public int hashCode() {
        return Objects.hash(color, numberPlate);
    }
}
