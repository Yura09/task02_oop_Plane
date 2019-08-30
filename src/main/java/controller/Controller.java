package controller;

import model.BusinessLogic;
import model.Model;
import model.Plane;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;

    public Controller() {
        model = new BusinessLogic();
    }

    public ArrayList<? extends Plane> getPassengerPlane() {
        return model.getPassengerPlane();
    }

    public ArrayList<? extends Plane> getMilitaryPlane() {
        return model.getMilitaryPlane();
    }

    public List<Plane> sortBy(String sort) {
        return model.sortBy(sort);
    }

    public List<Plane> fuelConsumed(int from, int to) {
        return model.fuelConsumed(from, to);
    }

    public ArrayList<Plane> getAllPlanes() {
        return model.getAllPlanes();
    }


    public void execute() {
        new View().show();
    }

}
