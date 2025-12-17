package HotelManagement.service;

import java.sql.Date;
import java.util.List;

import HotelManagement.model.Booking;
import HotelManagement.model.Customer;
import HotelManagement.model.Room;
import HotelManagement.repository.BookingRepository;

public class BookingService {


    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private RoomService roomService;

    public BookingService(BookingRepository bookingRepository, CustomerService customerService, RoomService roomService) {
        this.bookingRepository=bookingRepository;
        this.customerService=customerService;
        this.roomService=roomService;
    }

    public void makeBooking(Customer customer, Room room, Date checkIn, Date checkOut) {

        if (room.isBooked()) {
            System.err.println("Room Already Booked");
            return;
        }

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setCheckInDate(checkIn);
        booking.setCheckOutDate(checkOut);
        booking.setBookingStatus("CONFIRMED");

        long nights = Math.max(1, (checkOut.getTime() - checkIn.getTime()) / (1000L * 60 * 60 * 24));
        booking.setTotalPrice(room.getPricePerNight() * nights);

        room.setBooked(true);
        roomService.updateRoom(room); // persist room status

        bookingRepository.addBooking(booking);
    }


    public void cancelBooking(int bookingId) {
        Booking booking = bookingRepository.getBookingById(bookingId);

        if (booking != null) {
            booking.getRoom().setBooked(false);
            roomService.updateRoom(booking.getRoom()); // persist
            bookingRepository.removeBooking(bookingId);
            System.out.println("Booking canceled successfully");
        } else {
            System.out.println("No booking found with that ID");
        }
    }


    public Booking getBookingById(int bookingId) {
        return bookingRepository.getBookingById(bookingId);
    }

    public List<Booking> listAllBookings() {
        return bookingRepository.getAllBookings();
    }

    public List<Booking> listBookingsByCustomer(int custId) {
        return bookingRepository.getBookingsByCustomer(custId);
    }

    public double calculateIncome() {
        return bookingRepository.calculateIncome();
    }

}
