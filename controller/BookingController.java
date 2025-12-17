package HotelManagement.controller;

import java.sql.Date;


import HotelManagement.model.Booking;
import HotelManagement.model.Customer;
import HotelManagement.model.Room;
import HotelManagement.service.BookingService;
import HotelManagement.service.CustomerService;
import HotelManagement.service.RoomService;
import HotelManagement.util.InputUtil;

public class BookingController {

    private final BookingService bookingService;
    private final CustomerService customerService;
    private final RoomService roomService;

    public BookingController(BookingService bookingService, RoomService roomService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.customerService=customerService;
        this.roomService=roomService;

    }

    public void addBooking() {

        int custId = InputUtil.getInt("Enter Customer ID: ");
        Customer customer = customerService.getCustomerById(custId);

        if (customer == null) {
            InputUtil.println("Customer not found!");
            return;
        }

        int roomId = InputUtil.getInt("Enter Room ID: ");
        Room room = roomService.getRoomById(roomId);

        if (room == null) {
            InputUtil.println("Room not found!");
            return;
        }

        if (room.isBooked()) {
            InputUtil.println("Room is already booked!");
            return;
        }

        String checkInStr = InputUtil.getString("Enter Check-In Date (yyyy-mm-dd): ");
        String checkOutStr = InputUtil.getString("Enter Check-Out Date (yyyy-mm-dd): ");
        Date checkIn = Date.valueOf(checkInStr);
        Date checkOut = Date.valueOf(checkOutStr);

        bookingService.makeBooking(customer, room, checkIn, checkOut);

        InputUtil.println("Booking added successfully!");
    }

    public void cancelBooking() {
        int bookingId = InputUtil.getInt("Enter Booking Id: ");

        Booking booking = bookingService.getBookingById(bookingId);

        if (booking != null) {
            bookingService.cancelBooking(bookingId);
            System.out.println("Successfully Canceled Booking");
        }else{
            System.out.println("No Booking Found With That Id");
        }

    }

    public void getBookingById() {
        int bookingId = InputUtil.getInt("Enter Booking Id: ");
        Booking booking=bookingService.getBookingById(bookingId);

        if(booking==null)
        {
            System.out.println("Booking Not Found");
        }else{
            System.out.println("Booking Found");
            System.out.println(booking);
        }
    }

    public void getAllBookings() {

        System.out.println("--- All Bookings ---");
        bookingService.listAllBookings()
                .forEach(System.out::println);
    }

    public void listBookingByCustomer() {
        int custId = InputUtil.getInt("Enter Customer Id: ");
        System.out.println("List Of Bookings By Customer: ");
        bookingService.listBookingsByCustomer(custId).forEach(System.out::println);
    }

    public void calculateIncome()
    {
        double income=bookingService.calculateIncome();
        System.out.println("Total Income: "+income);
    }

}
