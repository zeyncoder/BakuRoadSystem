package TrafficSystem;

import TrafficException.TrafficException;

public class Main {
    public static void main(String[] args) {
        TrafficSystem system = new TrafficSystem();
        try {
            system.simulateTraffic();
        } catch (TrafficException e) {
            System.out.println(" Exception: " + e.getMessage());
        }
    }
}
