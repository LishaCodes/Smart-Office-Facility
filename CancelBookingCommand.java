// This class implements a command to cancel a room booking.
// It notifies the user when the booking is canceled.
public class CancelBookingCommand implements Command {
    private MeetingRoom room;

    // Constructor to initialize the command with a room
    public CancelBookingCommand(MeetingRoom room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.cancelBooking();
    }
}
