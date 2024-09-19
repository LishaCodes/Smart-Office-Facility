import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// This class represents a meeting room in the office.
public class MeetingRoom implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int roomId;
    private int maxCapacity;
    private boolean isOccupied;
    private Date bookingEndTime;
    private int energyConsumption;
    private List<String> feedback;
    private boolean isBooked;

    // Constructor to initialize a meeting room
    public MeetingRoom(int roomId, int maxCapacity) {
        this.roomId = roomId;
        this.maxCapacity = maxCapacity;
        this.feedback = new ArrayList<>();
        this.isBooked = false;
    }

    // Method to add occupants to the room
    public void addOccupants(int count) {
        if (count < 2) {
            System.out.println("Error: At least 2 people needed for occupancy.");
            return;
        }
        this.isOccupied = true;
        this.bookingEndTime = new Date(System.currentTimeMillis() + 5 * 60 * 1000); // Auto-release in 5 minutes
        this.energyConsumption += 10; // Simple energy calculation
        notifyObservers(); // Notify all observers of the change
    }

    // Method to remove occupants from the room
    public void removeOccupants() {
        this.isOccupied = false;
        this.bookingEndTime = null;
        notifyObservers(); // Notify all observers of the change
    }

    // Method to add feedback for the room
    public void addFeedback(String comment) {
        feedback.add(comment);
        System.out.println("Feedback added for Room " + roomId + ": " + comment);
    }

    // Method to book the room
    public void book(int duration) {
        if (isBooked) {
            System.out.println("Room " + roomId + " is already booked.");
            return;
        }
        this.isBooked = true;
        this.bookingEndTime = new Date(System.currentTimeMillis() + duration * 60 * 1000); // Set booking end time
        System.out.println("Room " + roomId + " booked for " + duration + " minutes.");
    }

    // Method to cancel the booking
    public void cancelBooking() {
        if (!isBooked) {
            System.out.println("Room " + roomId + " is not booked.");
            return;
        }
        this.isBooked = false;
        this.bookingEndTime = null;
        System.out.println("Booking for Room " + roomId + " canceled.");
    }

    // Getters for various properties
    public int getRoomId() {
        return roomId;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Date getBookingEndTime() {
        return bookingEndTime;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public boolean isBooked() {
        return isBooked;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(isOccupied);
        }
    }
}
