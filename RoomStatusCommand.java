// This class implements a command to check the status of a room.
// It displays occupancy status, energy consumption, and feedback.
public class RoomStatusCommand implements Command {
    private MeetingRoom room;

    // Constructor to initialize the command with a room
    public RoomStatusCommand(MeetingRoom room) {
        this.room = room;
    }

    @Override
    public void execute() {
        String status = room.isOccupied() ? "occupied" : "unoccupied";
        System.out.println("Room " + room.getRoomId() + " is " + status + ".");
        System.out.println("Energy Consumption: " + room.getEnergyConsumption() + " units.");
        System.out.println("Feedback: " + room.getFeedback());
        if (room.isBooked()) {
            System.out.println("Room is currently booked.");
        } else {
            System.out.println("Room is available.");
        }
    }
}
