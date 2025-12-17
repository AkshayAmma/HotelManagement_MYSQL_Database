package HotelManagement.model;

public class Room {
    private int roomId;
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isBooked;
    private int capacity;
    private int floorNumber;

    public Room() {

    }

    public Room(int roomId, String roomNumber, String roomType, double pricePerNight, boolean isBooked, int capacity,
                int floorNumber) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
        this.capacity = capacity;
        this.floorNumber = floorNumber;
    }

    public Room(String roomNumber, String roomType, double pricePerNight, boolean isBooked, int capacity,
                int floorNumber) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
        this.capacity = capacity;
        this.floorNumber = floorNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", pricePerNight="
                + pricePerNight + ", isBooked=" + isBooked + ", capacity=" + capacity + ", floorNumber="
                + floorNumber + "]";
    }


}
