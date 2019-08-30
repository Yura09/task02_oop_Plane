package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {


    private ArrayList<Plane> planes;

    public Airport() {
        this.planes = new ArrayList<>();
        addPlanes();
    }

    public ArrayList<Plane> getAllPlanes() {
        return planes;
    }

    public ArrayList<? extends Plane> getPassengerPlane() {
        ArrayList<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public ArrayList<? extends Plane> getMilitaryPlane() {
        ArrayList<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    private void addPlanes() {

        planes.add(new PassengerPlane("Boeing-747", 10000, 10000, 1000, 500000, 12, 200));
        planes.add(new MilitaryPlane("T8D", 8000, 7000, 1600, 90000, 18, "Bomber"));
        planes.add(new PassengerPlane("Boeing-666", 80000, 90000, 800, 400000, 10, 180));
        planes.add(new MilitaryPlane("A6M", 1000, 6000, 1500, 10000, 20, "Fighter"));

    }

    public List<Plane> sortBy(String sort) {
        switch (sort) {
            case "model":
                return planes.stream().sorted(Comparator.comparing(Plane::getModel)).collect(Collectors.toList());

            case "flightDistance":
                return planes.stream().sorted(Comparator.comparing(Plane::getFlightDistance)).collect(Collectors.toList());
            default:
                System.out.println("Wrong sorting type (check documentation)");
                return null;

        }
    }

    public List<Plane> fuelConsumed(int from, int to) {
        return planes.stream().filter(p -> p.getFuelUsage() <= to && p.getFuelUsage() >= from).collect(Collectors.toList());
    }

}
