package model;

import java.util.Objects;

public class MilitaryPlane extends Plane {
    private String type;

    public MilitaryPlane(String model, int loadCapacity, int flightDistance, int maxSpeed, int fuelCapacity, int fuelUsagePerKilometer, String type) {
        super(model, loadCapacity, flightDistance, maxSpeed, fuelCapacity, fuelUsagePerKilometer);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "type of plane" + type +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return type.equals( that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
