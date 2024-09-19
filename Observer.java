// Observers need to implement this so as to receive updates from the subject.
public interface Observer {
    void update(boolean isOccupied);
}
