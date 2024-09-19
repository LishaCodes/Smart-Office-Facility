// This is a singleton class. it manages the configuration of meeting rooms in the office.
import java.util.HashMap;
import java.util.Map;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private static final Object lock = new Object();
    private Map<Integer, MeetingRoom> rooms;

    private OfficeConfiguration() {
        rooms = new HashMap<>();
    }

    public static OfficeConfiguration getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new OfficeConfiguration();
            }
            return instance;
        }
    }
    // Create a new room with its capacity
    public void configureRoom(int roomId, int capacity) {
        if (capacity <= 0) {
            System.out.println("Error: Capacity must be positive.");
            return;
        }
        rooms.put(roomId, new MeetingRoom(roomId, capacity));
    }

    public MeetingRoom getRoom(int roomId) {
        return rooms.get(roomId);
    }
}
