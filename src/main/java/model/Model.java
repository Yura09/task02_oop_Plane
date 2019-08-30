package model;

import java.util.ArrayList;
import java.util.List;

public interface Model {
    ArrayList<? extends Plane> getPassengerPlane();

    ArrayList<? extends Plane> getMilitaryPlane();

    List<Plane> sortBy(String sort);

    List<Plane> fuelConsumed(int from, int to);

    ArrayList<Plane> getAllPlanes();
}
