import java.util.*;

class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean isBooked;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public void cancelBooking() {
        isBooked = false;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + category + "] - ₹" + price + " - " + (isBooked ? "BOOKED" : "AVAILABLE");
    }
}

class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void displayRooms() {
        System.out.println("\n🏨 Room List in " + name + ":");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public Room findRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                return r;
            }
        }
        return null;
    }

    public void bookRoom(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            if (!room.isBooked()) {
                room.bookRoom();
                System.out.println("✅ Room " + roomNumber + " booked successfully!");
            } else {
                System.out.println("❌ Room " + roomNumber + " is already booked!");
            }
        } else {
            System.out.println("❌ Invalid room number!");
        }
    }

    public void cancelBooking(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            if (room.isBooked()) {
                room.cancelBooking();
                System.out.println("✅ Booking for Room " + roomNumber + " cancelled successfully!");
            } else {
                System.out.println("❌ Room " + roomNumber + " is not booked!");
            }
        } else {
            System.out.println("❌ Invalid room number!");
        }
    }
}

public class task3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("Grand Palace Hotel");

        // Add sample rooms
        hotel.addRoom(new Room(101, "Standard", 2500));
        hotel.addRoom(new Room(102, "Deluxe", 3500));
        hotel.addRoom(new Room(103, "Suite", 5000));

        int choice;
        do {
            System.out.println("\n====== HOTEL RESERVATION SYSTEM ======");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayRooms();
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNum = sc.nextInt();
                    hotel.bookRoom(roomNum);
                    break;

                case 3:
                    System.out.print("Enter room number to cancel booking: ");
                    int cancelNum = sc.nextInt();
                    hotel.cancelBooking(cancelNum);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
