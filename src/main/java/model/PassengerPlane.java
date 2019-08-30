package model;

import java.util.Objects;

public class PassengerPlane extends Plane {
    private int passengerCapacity;

    public PassengerPlane(String model, int loadCapacity, int flightDistance, int maxSpeed, int fuelCapacity, int fuelUsagePerKilometer, int passengerCapacity) {
        super(model, loadCapacity, flightDistance, maxSpeed, fuelCapacity, fuelUsagePerKilometer);
        this.passengerCapacity = passengerCapacity;
    }

    public double getFlightPrice() {
        return flightDistance * 18;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengerCapacity=" + passengerCapacity +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return passengerCapacity == that.passengerCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerCapacity);
    }
}
