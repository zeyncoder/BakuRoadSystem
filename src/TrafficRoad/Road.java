package TrafficRoad;

public class Road {
    private String name;
    private int speedlimit;

    public String getName() {
        return name;
    }

    public int getSpeedlimit() {
        return speedlimit;
    }


    public Road(String name, int speedlimit) {
        this.name = name;
        this.speedlimit = speedlimit;

    }
    public String toString() {
        return name + " (limit " + speedlimit + " km/h)";
    }


    }




