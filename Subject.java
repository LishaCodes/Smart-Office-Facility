
// It allows users to be registered, removed, and notified of changes.
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
