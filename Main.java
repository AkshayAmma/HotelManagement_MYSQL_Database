package HotelManagement;

import java.util.Scanner;

import HotelManagement.controller.BookingController;
import HotelManagement.controller.CustomerController;
import HotelManagement.controller.RoomController;
import HotelManagement.repository.BookingRepository;
import HotelManagement.repository.CustomerRepository;
import HotelManagement.repository.RoomRepository;
import HotelManagement.service.BookingService;
import HotelManagement.service.CustomerService;
import HotelManagement.service.RoomService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomRepository roomRepository = new RoomRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        BookingRepository bookingRepository = new BookingRepository();

        RoomService roomService=new RoomService(roomRepository);
        CustomerService customerService=new CustomerService(customerRepository);
        BookingService bookingService=new BookingService(bookingRepository,customerService,roomService);

        RoomController roomController = new RoomController(roomService);
        CustomerController customerController = new CustomerController(customerService);
        BookingController bookingController = new BookingController(bookingService,roomService,customerService);

        while (true) {
            System.out.println("====== Welcome To Hotel Management System ======");
            System.out.println("1) Room Management");
            System.out.println("2) Customer Management");
            System.out.println("3) Booking Management");
            System.out.println("4) Exit");
            System.out.println("Enter Your Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    roomMenu(scanner, roomController);
                    break;
                case 2:
                    customerMenu(scanner, customerController);
                    break;
                case 3:
                    bookingMenu(scanner,bookingController,roomController,customerController);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option: ");
            }
        }
    }

    public static void roomMenu(Scanner scanner, RoomController roomController) {
        while (true) {
            System.out.println("------- Room Menu --------");
            System.out.println("1) Add Room");
            System.out.println("2) Remove Room");
            System.out.println("3) Update Room");
            System.out.println("4) Get Room By Id");
            System.out.println("5) Get Available Rooms");
            System.out.println("6) Search Room By Type");
            System.out.println("7) Search Room By Capacity");
            System.out.println("8) Mark Room As Booked");
            System.out.println("9) Mark Room As Available");
            System.out.println("10) <- Back");

            System.out.println("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    roomController.addRoom();
                    break;
                case 2:
                    roomController.removeRoom();
                    break;
                case 3:
                    roomController.updateRoom();
                    break;
                case 4:
                    roomController.getRoomById();
                    break;
                case 5:
                    roomController.getAvailableRooms();
                    break;
                case 6:
                    roomController.searchRoomByType();
                    break;
                case 7:
                    roomController.searchRoomByCapacity();
                    break;
                case 8:
                    roomController.markRoomAsBooked();
                    break;
                case 9:
                    roomController.markRoomAsAvailable();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid Choice: ");

            }

        }
    }

    public static void customerMenu(Scanner scanner, CustomerController customerController) {
        while (true) {
            System.out.println("---- Customer Menu ----");
            System.out.println("1) Add Customer");
            System.out.println("2) Get Customer By Id");
            System.out.println("3) Update Customer");
            System.out.println("4) Get All Customers");
            System.out.println("5) <- Back");

            System.out.println("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    customerController.addCustomer();
                    break;
                case 2:
                    customerController.getCustomerById();
                    break;
                case 3:
                    customerController.updateCustomer();
                    break;
                case 4:
                    customerController.getAllCustomers();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    public static void bookingMenu(Scanner scanner, BookingController bookingController,RoomController roomController,CustomerController customerController) {
        while (true) {
            System.out.println("----- Booking Menu -----");
            System.out.println("1) AddBooking");
            System.out.println("2) Cancel Booking");
            System.out.println("3) Get Booking By Id");
            System.out.println("4) Get All Bookings");
            System.out.println("5) List Of Bookings By A Customer");
            System.out.println("6) Calculate Total Income");
            System.out.println("7) <- Back");

            System.out.println("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    bookingController.addBooking();
                    break;
                case 2:
                    bookingController.cancelBooking();
                    break;
                case 3:
                    bookingController.getBookingById();
                    break;
                case 4:
                    bookingController.getAllBookings();
                    break;
                case 5:
                    bookingController.listBookingByCustomer();
                    break;
                case 6:
                    bookingController.calculateIncome();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid Option: ");

            }
        }
    }

}
