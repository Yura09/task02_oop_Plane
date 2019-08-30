package model;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic implements Model {
    private Airport model;
    public BusinessLogic(){
        model=new Airport();
    }

    @Override
    public ArrayList<? extends Plane> getPassengerPlane() {
        return model.getPassengerPlane();
    }

    @Override
    public ArrayList<? extends Plane> getMilitaryPlane() {
        return model.getMilitaryPlane();
    }

    @Override
    public List<Plane> sortBy(String sort) {
        return model.sortBy(sort);
    }

    @Override
    public List<Plane> fuelConsumed(int from, int to) {
        return model.fuelConsumed(from, to);
    }

    @Override
    public ArrayList<Plane> getAllPlanes() {
        return model.getAllPlanes();
    }
}
