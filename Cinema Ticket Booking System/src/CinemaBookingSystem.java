import java.util.Scanner;

public class CinemaBookingSystem {

    static Scanner input = new Scanner(System.in);

    static char[][] seats = new char[5][6];
    static String[] movieNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"};

    public static void main(String[] args) {

        initializeSeats();

        int choice;

        do {
            System.out.println("\n===== Cinema Ticket Booking System =====");
            System.out.println("1. Display Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show All Movies");
            System.out.println("5. Show Available and Booked Seats");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    showMovies();
                    break;
                case 5:
                    showSeatStatistics();
                    break;
                case 0:
                    System.out.println("Thank you for using the Cinema Booking System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'O';
            }
        }
    }

    public static void displaySeats() {
        System.out.println("\nSeat Layout");
        System.out.print("   ");
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bookSeat() {

        System.out.print("Enter seat number (RowColumn): ");
        int seatNumber = input.nextInt();

        int row = seatNumber / 10;
        int col = seatNumber % 10;

        if (!isValidSeat(row, col)) {
            System.out.println("Invalid Seat.");
            return;
        }

        if (seats[row - 1][col - 1] == 'X') {
            System.out.println("Seat already booked.");
        } else {
            seats[row - 1][col - 1] = 'X';
            System.out.println("Seat booked successfully.");
        }

        checkAlmostFull();
    }

    public static void cancelBooking() {

        System.out.print("Enter seat number (RowColumn): ");
        int seatNumber = input.nextInt();

        int row = seatNumber / 10;
        int col = seatNumber % 10;

        if (!isValidSeat(row, col)) {
            System.out.println("Invalid Seat.");
            return;
        }

        if (seats[row - 1][col - 1] == 'O') {
            System.out.println("Seat is already available.");
        } else {
            seats[row - 1][col - 1] = 'O';
            System.out.println("Booking cancelled.");
        }
    }

    public static void showMovies() {
        System.out.println("\nMovies:");
        for (int i = 0; i < movieNames.length; i++) {
            System.out.println((i + 1) + ". " + movieNames[i]);
        }
    }

    public static void showSeatStatistics() {

        int booked = 0;
        int available = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'X')
                    booked++;
                else
                    available++;
            }
        }

        System.out.println("Booked Seats: " + booked);
        System.out.println("Available Seats: " + available);
    }

    public static boolean isValidSeat(int row, int col) {
        return row >= 1 && row <= 5 && col >= 1 && col <= 6;
    }

    public static void checkAlmostFull() {

        int booked = 0;
        int total = seats.length * seats[0].length;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'X')
                    booked++;
            }
        }

        if ((double) booked / total > 0.8) {
            System.out.println("Almost Full");
        }
    }
}