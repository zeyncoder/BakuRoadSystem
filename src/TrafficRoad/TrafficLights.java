package TrafficRoad;

public class TrafficLights {
     private  String color;
    public TrafficLights(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public void changeColor(String newColor) {
        System.out.println("Traffic light changed from " + color + " to " + newColor);
        this.color = newColor;
    }

    @Override
    public String toString() {
        return "Traffic light is " + color;
    }
}


