# Smart Office Facility

This project is a console-based application that manages a smart office facility, including conference room bookings, occupancy detection, and automated control of air conditioning and lighting based on room occupancy.

## Features

### Mandatory Features:
1. **Configure Office Facility**: Set up the number of meeting rooms in the facility.
2. **Book & Cancel Bookings**: Users can book and cancel conference rooms.
3. **Occupancy Detection**: Occupancy is detected when at least two people enter a room.
4. **Auto-Release Bookings**: Unoccupied rooms release bookings after 5 minutes of inactivity.
5. **Automated AC & Lighting**: AC and lights automatically turn off when a room is unoccupied.

### Optional Features:
1. **Room Usage Statistics**: Provides a summary of room usage.
2. **User Authentication**: Restricts access to booking and configuration features.
3. **Notification System**: Sends notifications (email/SMS) when a booking is automatically released.

## Design Patterns Used

1. **Singleton Pattern**: Used to manage the global state of office configuration and room booking system.
2. **Observer Pattern**: Sensors monitor room occupancy and control systems (AC, lighting) respond to occupancy status.
3. **Command Pattern**: Handles booking, cancellation, and room status updates to ensure flexibility and extendability.
