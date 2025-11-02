package model;

public class Bus  extends Vehicle {
    private int passengerCapacity;
    public Bus(String licensePlate, int speed, String route) {
        super(licensePlate, speed, route);
        this.passengerCapacity =passengerCapacity;

    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public String toString() {
        return super.toString() + ", passengerCapacity=" + passengerCapacity;
    }
}
