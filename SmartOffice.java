import java.util.Scanner;

public class SmartOffice {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OfficeConfiguration officeConfig = OfficeConfiguration.getInstance();
        officeConfig.configureRoom(1, 10);
        officeConfig.configureRoom(2, 8);

        MeetingRoom room1 = officeConfig.getRoom(1);
        MeetingRoom room2 = officeConfig.getRoom(2);

        Sensor sensor = new Sensor();
        room1.registerObserver(sensor);
        room2.registerObserver(sensor);

        while (true) {
            System.out.println("Smart Office Menu:");
            System.out.println("1. Book Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Check Room Status");
            System.out.println("4. Add Occupants");
            System.out.println("5. Remove Occupants");
            System.out.println("6. Add Feedback");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    bookRoom(officeConfig);
                    break;
                case 2:
                    cancelBooking(officeConfig);
                    break;
                case 3:
                    checkRoomStatus(officeConfig);
                    break;
                case 4:
                    addOccupants(officeConfig);
                    break;
                case 5:
                    removeOccupants(officeConfig);
                    break;
                case 6:
                    addFeedback(officeConfig);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookRoom(OfficeConfiguration officeConfig) {
        System.out.print("Enter room number: ");
        int roomId = scanner.nextInt();
        System.out.print("Enter booking duration (minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); 

        MeetingRoom room = officeConfig.getRoom(roomId);
        if (room != null) {
            Command bookCommand = new BookRoomCommand(room, duration);
            bookCommand.execute();
        } else {
            System.out.println("Room " + roomId + " does not exist.");
        }
    }

    private static void cancelBooking(OfficeConfiguration officeConfig) {
        System.out.print("Enter room number: ");
        int roomId = scanner.nextInt();
        scanner.nextLine(); 

        MeetingRoom room = officeConfig.getRoom(roomId);
        if (room != null) {
            Command cancelCommand = new CancelBookingCommand(room);
            cancelCommand.execute();
        } else {
            System.out.println("Room " + roomId + " does not exist.");
        }
    }

    private static void checkRoomStatus(OfficeConfiguration officeConfig) {
        System.out.print("Enter room number: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();

        MeetingRoom room = officeConfig.getRoom(roomId);
        if (room != null) {
            Command statusCommand = new RoomStatusCommand(room);
            statusCommand.execute();
        } else {
            System.out.println("Room " + roomId + " does not exist.");
        }
    }

    private static void addOccupants(OfficeConfiguration officeConfig) {
        System.out.print("Enter room number: ");
        int roomId = scanner.nextInt();
        System.out.print("Enter number of occupants: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

        MeetingRoom room = officeConfig.getRoom(roomId);
        if (room != null) {
            room.addOccupants(count);
        } else {
            System.out.println("Room " + roomId + " does not exist.");
        }
    }

    private static void removeOccupants(OfficeConfiguration officeConfig) {
        System.out.print("Enter room number: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();

        MeetingRoom room = officeConfig.getRoom(roomId);
        if (room != null) {
            room.removeOccupants();
        } else {
            System.out.println("Room " + roomId + " does not exist.");
        }
    }

    private static void addFeedback(OfficeConfiguration officeConfig) {
        System.out.print("Enter room number: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();

        MeetingRoom room = officeConfig.getRoom(roomId);
        if (room != null) {
            room.addFeedback(feedback);
        } else {
            System.out.println("Room " + roomId + " does not exist.");
        }
    }
}
