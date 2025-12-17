package HotelManagement.repository;

import HotelManagement.model.Booking;
import HotelManagement.model.Customer;
import HotelManagement.model.Room;
import HotelManagement.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    public void addBooking(Booking booking) {

        String sql = "INSERT INTO booking " +
                "(CustomerId, RoomId, CheckInDate, CheckOutDate, TotalPrice, BookingStatus) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setInt(1, booking.getCustomer().getCustomerId());
            preparedStatement.setInt(2, booking.getRoom().getRoomId());
            preparedStatement.setDate(3, booking.getCheckInDate());
            preparedStatement.setDate(4, booking.getCheckOutDate());
            preparedStatement.setDouble(5, booking.getTotalPrice());
            preparedStatement.setString(6, booking.getBookingStatus());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Booking getBookingById(int bookingId) {

        String sql = "SELECT * FROM booking WHERE BookingId=?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, bookingId);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {

                int customerId = set.getInt("CustomerId");
                int roomId = set.getInt("RoomId");

                CustomerRepository customerRepository = new CustomerRepository();
                RoomRepository roomRepository = new RoomRepository();

                Customer customer = customerRepository.getCustomerById(customerId);
                Room room = roomRepository.getRoomById(roomId);

                return new Booking(
                        set.getInt("BookingId"),
                        customer,
                        room,
                        set.getDate("CheckInDate"),
                        set.getDate("CheckOutDate"),
                        set.getDouble("TotalPrice"),
                        set.getString("BookingStatus")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void removeBooking(int bookingId) {
        String sql = "DELETE FROM booking WHERE BookingId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, bookingId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM booking";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet set = preparedStatement.executeQuery()) {

            CustomerRepository customerRepository = new CustomerRepository();
            RoomRepository roomRepository = new RoomRepository();

            while (set.next()) {
                Customer customer = customerRepository.getCustomerById(set.getInt("CustomerId"));
                Room room = roomRepository.getRoomById(set.getInt("RoomId"));

                bookings.add(new Booking(
                        set.getInt("BookingId"),
                        customer,
                        room,
                        set.getDate("CheckInDate"),
                        set.getDate("CheckOutDate"),
                        set.getDouble("TotalPrice"),
                        set.getString("BookingStatus")
                ));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookings;
    }

    public List<Booking> getBookingsByCustomer(int custId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM booking WHERE CustomerId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, custId);
            ResultSet set = preparedStatement.executeQuery();

            CustomerRepository customerRepository = new CustomerRepository();
            RoomRepository roomRepository = new RoomRepository();

            Customer customer = customerRepository.getCustomerById(custId);

            while (set.next()) {
                Room room = roomRepository.getRoomById(set.getInt("RoomId"));

                bookings.add(new Booking(
                        set.getInt("BookingId"),
                        customer,
                        room,
                        set.getDate("CheckInDate"),
                        set.getDate("CheckOutDate"),
                        set.getDouble("TotalPrice"),
                        set.getString("BookingStatus")
                ));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookings;

    }

    public double calculateIncome() {
        String sql = "SELECT SUM(TotalPrice) AS totalIncome FROM booking";
        double income = 0;

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet set = preparedStatement.executeQuery()) {

            if (set.next()) {
                income = set.getDouble("totalIncome");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return income;
    }
}
