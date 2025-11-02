package model;

import TrafficException.TrafficException;

public class Vehicle {
    private String licensePlate;
   private int speed;
    private String route;

    @Override
    public String toString() {
        return " " +
                "nomre nisani='" + licensePlate + '\'' +
                ", speed=" + speed +
                ", route='" + route + '\'' +
                '}';
    }




    public String getLicensePlate() {
        return licensePlate;
    }


    public int getSpeed() {
        return speed;
    }


    public String getRoute() {
        return route;
    }

    public Vehicle(String licensePlate, int speed, String route) {
        this.licensePlate = licensePlate;
        this.speed = speed;
        this.route = route;
    }
    }




