package HotelManagement.model;

import java.sql.Date;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private String bookingStatus;

    public  Booking()
    {

    }

    public Booking(int bookingId, Customer customer, Room room, Date checkInDate, Date checkOutDate, double totalPrice,
                   String bookingStatus) {
        this.bookingId=bookingId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }


    public Booking(Customer customer, Room room, Date checkInDate, Date checkOutDate, double totalPrice,
            String bookingStatus) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", customer=" + customer + ", room=" + room + ", checkInDate="
                + checkInDate + ", checkOutDate=" + checkOutDate + ", totalPrice=" + totalPrice + ", bookingStatus="
                + bookingStatus + "]";
    }

}
