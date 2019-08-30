package view;

import controller.Controller;
import model.Plane;

import java.util.*;


public class View {

    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View() {
        controller = new Controller();
        menu = new LinkedHashMap<>();
        menu.put("1", "  1 - getPassengerPlane");
        menu.put("2", "  2 - geMilitaryPlane");
        menu.put("3", "  3 - sortBy(type of sorting)");
        menu.put("4", "  4 - getFuelConsumed");
        menu.put("5", "  5 - print all planes in the airport");
        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
        methodsMenu.put("5", this::pressButton5);
    }

    private void pressButton1() {
        ArrayList<? extends Plane> planes = controller.getPassengerPlane();
        planes.forEach(System.out::println);
    }

    private void pressButton2() {
        ArrayList<? extends Plane> planes = controller.getMilitaryPlane();
        planes.forEach(System.out::println);
    }


    private void pressButton3() {
        System.out.println("Please input one type of sorting (model, flightDistance):");
        String sortBy = input.nextLine();
        List<Plane> planes = controller.sortBy(sortBy);
        System.out.println("planes sorted by " + sortBy);
        planes.forEach(System.out::println);

    }

    private void pressButton4() {
        System.out.print("Please input interval of fuel consumed(from, to):");
        int from = input.nextInt();
        int to = input.nextInt();
        List<Plane> planes = controller.fuelConsumed(from, to);
        if (!planes.isEmpty()) {
            System.out.println("planes with fuel consumed between+ [" + from + ", " + to + "]");
        } else {
            System.out.println("planes with this range not found");
            return;
        }
        planes.forEach(System.out::println);
    }

    private void pressButton5() {
        controller.getAllPlanes().forEach(System.out::println);
    }

    //-------------------------------------------------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
