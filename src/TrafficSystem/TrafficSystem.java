package TrafficSystem;

import TrafficException.TrafficException;
import TrafficRoad.Road;
import TrafficRoad.TrafficLights;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrafficSystem {

    private int chances = 3;
    private int penaltyPoints = 0;
    private int fine = 0;
    private int speed = 0;

    private List<Road> roads = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<TrafficLights> lights = new ArrayList<>();
    private Random rand = new Random();



    void addRoad() {
        roads.add(new Road("BabekStreet", 110));
        roads.add(new Road("GaraGarayev", 90));
        roads.add(new Road("Neftchilar", 120));
    }



    void addVehicle() {
        vehicles.add(new Car("10-AA-111", 120, "BabekStreet"));
        vehicles.add(new Bus("90-AA-222", 85, "GaraGarayev"));
        vehicles.add(new Truck("77-AA-333", 115, "Neftchilar"));
        vehicles.add(new EmergencyVehicle("99-AA-444", 150, "BabekStreet"));

    }



    void addLights() {
        lights.add(new TrafficLights("Red"));
        lights.add(new TrafficLights("Yellow"));
        lights.add(new TrafficLights("Green"));
    }



    public void simulateTraffic() throws TrafficException {
        addRoad();
        addVehicle();
        addLights();

        System.out.println(" Mövcud işıqlar:");
        for (TrafficLights l : lights)
            System.out.println("   " + l);

        for (Vehicle vehicle : vehicles) {
            Road road = findRoadByName(vehicle.getRoute());
            speed = vehicle.getSpeed();

            System.out.println(" Nəqliyyat vasitəsi: " + vehicle);
            System.out.println(" Yol: " + road.getName() + " | Limit: " + road.getSpeedlimit());

            if (vehicle instanceof EmergencyVehicle) {
                System.out.println(" Bu təcili yardım maşınıdır — qayda pozuntusu hesablanmır!");
                continue;
            }


            if (speed > road.getSpeedlimit()) {
                addPenalty();
                System.out.println(" " + vehicle.getLicensePlate() + " sürət limitini keçdi!");
            } else {
                System.out.println("  " + vehicle.getLicensePlate() + " qaydalara əməl edir.");
            }
        }

        TrafficLights activeLight = lights.get(rand.nextInt(lights.size()));
        System.out.println(" İşıq dəyişir...");
        activeLight.changeColor("Green");
        System.out.println(" Yeni vəziyyət: " + activeLight);
    }



    public void addPenalty() throws TrafficException {
        chances--;
        penaltyPoints += 10;
        fine += 50;
        System.out.println("Cəza əlavə edildi → Xal: " + penaltyPoints +
                " | Cərimə: " + fine + " AZN | Qalan şans: " + chances);

        if (chances <= 0) {
            throw new TrafficException(" Lisenziya ləğv edildi!");
        }

    }



    private Road findRoadByName(String name) {
        for (Road road : roads) {
            if (road.getName().equalsIgnoreCase(name)) {
                return road;
            }
        }
        return null;
    }
}
