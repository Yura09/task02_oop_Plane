package model;

import java.util.Objects;

public abstract class Plane {
    protected String model;
    protected int loadCapacity;
    protected int flightDistance;
    protected int maxSpeed;
    protected int fuelCapacity;
    protected int fuelUsagePerKilometer;

    public Plane(String model, int loadCapacity, int flightDistance, int maxSpeed, int fuelCapacity, int fuelUsagePerKilometer) {
        this.model = model;
        this.loadCapacity = loadCapacity;
        this.flightDistance = flightDistance;
        this.maxSpeed = maxSpeed;
        this.fuelCapacity = fuelCapacity;
        this.fuelUsagePerKilometer = fuelUsagePerKilometer;
    }

    public int getFuelUsage() {

        return flightDistance / fuelUsagePerKilometer;

    }

    public int getFuelLeft() {
        return fuelCapacity - getFuelUsage();
    }

    public String getModel() {
        return model;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    int getFlightDistance() {
        return flightDistance;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return loadCapacity == plane.loadCapacity &&
                flightDistance == plane.flightDistance &&
                maxSpeed == plane.maxSpeed &&
                fuelCapacity == plane.fuelCapacity &&
                fuelUsagePerKilometer == plane.fuelUsagePerKilometer &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, loadCapacity, flightDistance, maxSpeed, fuelCapacity, fuelUsagePerKilometer);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", loadCapacity=" + loadCapacity +
                ", flightDistance=" + flightDistance +
                ", maxSpeed=" + maxSpeed +
                ", fuelCapacity=" + fuelCapacity +
                ", fuelUsagePerKilometer=" + fuelUsagePerKilometer +
                '}';
    }
}
