// This class implements a command to book a room.
// It checks if the room is available before booking.
public class BookRoomCommand implements Command {
    private MeetingRoom room;
    private int duration;

    // Constructor to initialize the command with room and duration
    public BookRoomCommand(MeetingRoom room, int duration) {
        this.room = room;
        this.duration = duration;
    }

    @Override
    public void execute() {
        room.book(duration);
    }
}
