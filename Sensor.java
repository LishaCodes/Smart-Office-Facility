// ths class reacts to changes in room occupancy.
public class Sensor implements Observer {
    @Override
    public void update(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Sensor: Room is occupied. Turning on AC and lights.");
        } else {
            System.out.println("Sensor: Room is unoccupied. Turning off AC and lights.");
        }
    }
}
